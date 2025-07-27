package stellarburgers.steps;

import io.restassured.response.Response;
import stellarburgers.models.User;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class UserSteps {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";

    public Response register(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(BASE_URL + "/register");
    }

    public String getAccessToken(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(BASE_URL + "/login")
                .then()
                .statusCode(SC_OK)
                .extract()
                .path("accessToken");
    }

    public void delete(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/user")
                .then()
                .statusCode(SC_ACCEPTED);
    }
}