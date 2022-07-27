package org.imersao.controller;

import javax.ws.rs.core.Response.Status;

import org.approvaltests.Approvals;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.imersao.dto.StickerDto;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

@QuarkusTest
public class StickerControllerTest {

    @ConfigProperty(name = "token")
    String API_TOKEN;

    private RequestSpecification given() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", "Basic ".concat(API_TOKEN)));
    }

    @Test
    public void whenGenerateSticker() {
        var stikerDto = new StickerDto();

        stikerDto.setImagePath("https://avatars.githubusercontent.com/u/61207420?v=4");
        stikerDto.setImageText("Unit test!");

        var result = given()
                .body(stikerDto)
                .when().post("/image")
                .then()
                .statusCode(Status.OK.getStatusCode())
                .extract().asString();

        Approvals.verify(result);
    }

}
