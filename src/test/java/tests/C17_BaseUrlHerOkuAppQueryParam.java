package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C17_BaseUrlHerOkuAppQueryParam extends BaseUrlHerOkuApp {
/*

        "https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Jim” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            // ve “Jim” ismine sahip 4 booking oldugunu test edin

         */
    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Jim");
        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");
       // System.out.println(response.prettyPrint());
        response.then().assertThat().statusCode(200).body("size()", equalTo(7));


    }
}
