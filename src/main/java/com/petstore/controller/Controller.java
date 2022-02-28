package com.petstore.controller;

import com.petstore.Steps.Steps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Controller {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

    public Response getPet(String id) {
        return given(requestSpecification)
                .when()
                .body(id)
                .post();
    }
    public Response postPet(Object pet) {
        return given(requestSpecification)
                .when()
                .body(pet)
                .post();
    }

    public Response putPet(Object pet) {
        return given(requestSpecification)
                .when()
                .body(pet)
                .put();
    }

    public Steps deletePet(String id) {
        return (Steps) given(requestSpecification)
                .when()
                .delete(id);
    }
}
