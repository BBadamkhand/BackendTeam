package com.OppFi.offerEndPoint;

import com.OppFi.utilities.Environment;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OfferEndPoint {
    @DisplayName("Get Offer")
    @Test
    public void postA (){
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("socialSecurityNumber", "123456780");
        requestBody.put("stateCode", "FL");
        requestBody.put("Income", "100000");

        given()
                .accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Environment.TARGET_URL)
                .then()
                .statusCode(201)
                .contentType("application/json")
                .headers("Content-Type", "application/json", "x-api-key", Environment.API_KEY);

    }
    @DisplayName("Get declined Offer")
    @Test
    public void postB (){
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("socialSecurityNumber", "123450000");
        requestBody.put("stateCode", "IL");
        requestBody.put("Income", "100000");

        given()
                .accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Environment.TARGET_URL)
                .then()
                .statusCode(201)
                .contentType("application/json")
                .headers("Content-Type", "application/json", "x-api-key",Environment.API_KEY);

    }

    @DisplayName("Get Offer")
    @Test
    public void postC (){
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("socialSecurityNumber", "1234567811");
        requestBody.put("stateCode", "IL");
        requestBody.put("Income", "100000");

        given()
                .accept(ContentType.JSON).log().all()
                .and()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Environment.TARGET_URL)
                .then()
                .statusCode(201)
                .contentType("application/json")
                .headers("Content-Type", "application/json", "x-api-key",Environment.API_KEY);

    }
}
