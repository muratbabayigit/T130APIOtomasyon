package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
    https://reqres.in/api/users url'ine
        bir GET request yolladigimizda
        donen Response'in
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        ve response body'sindeki
        user sayisinin 6
        ve kayıtlardan birinin adını "Emma" oldugunu test edin.
   */


    @Test
    public void testGetUsers() {
        // GET request gönderiyoruz
        Response response = RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/users");

        // 1. Status code'un 200 olduğunu doğruluyoruz
        Assert.assertEquals(response.statusCode(), 200, "Status code doğru değil!");

        // 2. Content type'ın application/json olduğunu doğruluyoruz
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8", "Content type doğru değil!");

        // Response'u JSON olarak parse ediyoruz
        JsonPath jsonPath = response.jsonPath();

        // 3. Response body'sindeki user sayısının 6 olduğunu doğruluyoruz
        int userCount = jsonPath.getList("data").size();
        Assert.assertEquals(userCount, 6, "User sayısı beklenen değerden farklı!");

        // 4. Kayıtlardan birinin adının "Emma" olduğunu doğruluyoruz
        boolean isEmmaPresent = jsonPath.getList("data.first_name").contains("Emma");
        Assert.assertTrue(isEmmaPresent, "Emma isimli kullanıcı bulunamadı!");
    }
}




