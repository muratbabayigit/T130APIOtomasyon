package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {
/*
    https://restful-booker.herokuapp.com/booking/11 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json,
            ve response body’sindeki
            “firstname”in, “John”,
            ve “lastname”in, “Smith”,
            ve “totalprice”in, 111,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
	        NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
     */
    @Test
    public void bodyTekrarlardanKurtulma() {
        //1-EndPoint hazırlama
        String url="https://restful-booker.herokuapp.com/booking/11";
        //2-Soruda verilmedği için expected Body hazırlanmadı

         //3-Dönen Response kaydedilir
        Response response=given().when().get(url);

        //4-Assertionİşlemi yapılır
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));


    }
}
