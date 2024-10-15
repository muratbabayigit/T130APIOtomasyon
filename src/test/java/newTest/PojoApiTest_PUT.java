package newTest;

import baseUrl.ReqResBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ReqResPojo;

import static org.testng.Assert.assertEquals;


public class PojoApiTest_PUT extends ReqResBaseUrl {

   @Test
    public void testUpdateUser() {
        // Base URL
        specReqres.pathParams("pp1","api","pp2","users","pp3","2");

        // POJO kullanarak kullanıcıyı oluştur
        ReqResPojo user = new ReqResPojo("John Doe", "Manager");

        // PUT isteği yap ve yanıtı al
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .spec(specReqres)
                .body(user)
                .put("/{pp1}/{pp2}/{pp3}");

        // Yanıtı yazdır
        response.prettyPrint();

        // Durum kodunu doğrula
        assertEquals(200, response.getStatusCode(), "Status code is incorrect!");

        // 'name' alanını doğrula
        String name = response.jsonPath().getString("name");
        assertEquals("John Doe", name, "User name is incorrect!");

        // 'job' alanını doğrula
        String job = response.jsonPath().getString("job");
        assertEquals("Manager", job, "Job title is incorrect!");
    }
}

