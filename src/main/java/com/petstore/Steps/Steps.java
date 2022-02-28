package com.petstore.Steps;

import com.petstore.controller.Controller;
import com.petstore.pojo.Request.Pet;
import com.petstore.pojo.Response.ResponsePet;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Steps extends Controller {

    @Step("Create new pet {pet}")
    public Steps createPet(Pet pet){
        Response response = postPet(pet);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step("Create new pet - negative {pet}")
    public Steps createPetNegative(Pet pet){
        Response response = postPet(pet);
        assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
        return this;
    }

    @Step("Get pet by id {id}")
    public Pet getPetId(String id){
        Response response = getPet(id);
        assertStatusCode(HttpStatus.SC_OK ,response);
        return response.as(Pet.class);
    }

    @Step("Get pet by id - negative {id}")
    public Steps getNoPetById(String id) {
        Response response = getPet(id);
        assertStatusCode(HttpStatus.SC_NOT_FOUND, response);
        assertMessage("Pet not found", response.as(ResponsePet.class));
        return this;
    }

    @Step("Validate pet {expectedPet}")
    public Steps assertPet(Pet expectedPet){
        Pet pet = getPetId(expectedPet.getId().toString());
        assertThat(pet, equalTo(expectedPet));
        return this;
    }

    @Step("Delete pet by {id}")
    public Steps deletePet(String id){
        Response response = (Response) deletePet(id);
        assertStatusCode(HttpStatus.SC_OK, response);
        return this;
    }

    @Step ("Update pet {pet}")
    public Steps updatePet(Pet pet){
        Response response = putPet(pet);
        assertStatusCode(HttpStatus.SC_BAD_REQUEST, response);
        return this;
    }

    @Step("assert status")
    private void assertStatusCode(int statusCode, Response response){
        assertThat(response.statusCode(), equalTo(statusCode));
    }

    @Step("assert error message")
    private void assertMessage(String errorMesage, ResponsePet response){
        assertThat(response.getMessage(), equalTo(errorMesage));
    }
}
