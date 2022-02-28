package com.petstore.utils;

import com.petstore.pojo.Request.Category;
import com.petstore.pojo.Request.Pet;
import com.petstore.pojo.Request.Status;
import com.petstore.pojo.Request.Tag;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;

public class DataGenerator {

    public static Pet createPetWithFullDetails(){
        return Pet
                .builder()
                .id(getRandomInt())
                .name(getRandomString())
                .photoUrl(Arrays.asList(getRandomString()))
                .category(Category.builder().id(getRandomInt()).name(getRandomString()).build())
                .tags(Arrays.asList(Tag.builder().id(getRandomInt()).name(getRandomString()).build(),
                        Tag.builder().id(getRandomInt()).name(getRandomString()).build()))
                .status(Status.available)
                .build();

    }

    private static Integer getRandomInt() {
        return new Random().nextInt((1000) - 500);
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
