package org.tss;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TvResouceTest {
    
    @Test
    public void getAllTvShows() {

        TvShow tvShow = new TvShow();
        tvShow.title = "House";
        tvShow.completed = true;

        given()
                .body(tvShow)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .when()
                .post("/api/tvshow")
                .then()
                .statusCode(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body("title", is(tvShow.title));

       

        List<TvShow> result = given()
                .when()
                .get("/api/tvshow")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("$.size()", is(1))
                .extract().jsonPath().getList("", TvShow.class);
    }
}
