package apiTests.videoGameTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;

import static apiTests.videoGameTests.config.Constants.*;
import static apiTests.videoGameTests.config.ContentTypes.*;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameBase {

    @BeforeClass
    public static void setup(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(VIDEO_GAME_URI)
                .setBasePath(VIDEO_GAME_BASE_PATH)
                .setContentType(APP_JSON)
                .addHeader("Accept", APP_JSON)
                .addFilter(new RequestLoggingFilter())    //instead of '.log().all()' after 'when()'
                .addFilter(new ResponseLoggingFilter())   //instead of '.log().all()' after 'then()'
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L))
                .build();
    }
}
