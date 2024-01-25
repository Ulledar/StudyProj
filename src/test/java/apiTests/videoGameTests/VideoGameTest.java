package apiTests.videoGameTests;

import apiTests.videoGameTests.objects.VideoGamePOJO;
import apiTests.videoGameTests.objects.VideoGamePOJOWithLombok;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Test;

import static apiTests.videoGameTests.config.ContentTypes.*;
import static apiTests.videoGameTests.config.TestDataProvider.*;
import static apiTests.videoGameTests.config.VideoGameEndpoints.*;
import static io.restassured.RestAssured.given;

public class VideoGameTest extends VideoGameBase {


    //  region Schema
    @Test
    public void testVideoGameSchemaJSON() {
        given()
                .pathParam("videoGameId", 5)
                .when()
                .get(SINGLE_VIDEO_GAME)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }

    @Test
    public void testVideoGameSchemaXML() {
        given()
                .pathParam("videoGameId", 5)
                .accept(APP_XML)
                .when()
                .get(SINGLE_VIDEO_GAME)
                .then()
                .body(RestAssuredMatchers.matchesXsdInClasspath("VideoGameXSD.xsd"));
    }
    //  endregion

    //  region Deserialization
    @Test
    public void convertJsonToPOJO() {
        Response response = given()
                .pathParam("videoGameId", 5)
                .when()
                .get(SINGLE_VIDEO_GAME);

        VideoGamePOJO videoGame = response.getBody().as(VideoGamePOJO.class);

        System.out.println(videoGame.toString());
    }
    //  endregion

    //  region Serialization
    @Test
    public void testVideoGameSerializationByJSON() {
        VideoGamePOJO videoGame =
                new VideoGamePOJO("Shgoter", "MyAwesomeGame", "Mature", "2018-04-04", 5);

        given()
                .body(videoGame)
                .when()
                .post(ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    public void testVideoGameSerializationByJSONWithLombok() {
        VideoGamePOJOWithLombok videoGame =
                new VideoGamePOJOWithLombok("Shgoter", "MyAwesomeGame", "Mature", "2018-04-04", 5);

        given()
                .body(videoGame)
                .when()
                .post(ALL_VIDEO_GAMES)
                .then();
    }
    //  endregion

    //  region GET requests
    @Test
    public void getAllGames() {
        given()
                .when()
                .get(ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    public void getAllGamesWithEndpoint(){
        given()
                .get(ALL_VIDEO_GAMES)
                .then().log().all();
    }
    //  endregion of GET requests

    //  region POST requests
    @Test
    public void createNewGameByJSON(){
        given()
                .body(MARIO_GAME_BODY_BY_JSON)
                .when()
                .post(ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    public void createNewGameByXML() {
        given()
                .body(MARIO_GAME_BODY_BY_XML)
                .contentType(APP_XML)
                .accept(APP_XML)
                .when()
                .post(ALL_VIDEO_GAMES)
                .then();
    }
    //  endregion of POST requests

    //  region PUT requests
    @Test
    public void updateGameWithPathParam() {
        given()
                .pathParam("videoGameId", 3)
                .body(MARIO_GAME_BODY_BY_JSON)
                .when()
                .put(SINGLE_VIDEO_GAME)
                .then();
    }

    @Test
    public void updateGameWithoutParam() {
        given()
                .body(MARIO_GAME_BODY_BY_JSON)
                .when()
                .put("/videogame/3")
                .then();
    }
    //  endregion of PUT requests

    //  region DELETE requests
    @Test
    public void deleteGame() {
        given()
                .pathParam("videoGameId", 3)
                .accept(TEXT_PLAIN)
                .when()
                .delete(SINGLE_VIDEO_GAME)
                .then();
    }
    //  endregion of DELETE requests
}
