package newTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest_POST {

/*
        ReqRes API kullanarak yeni bir kullanıcı oluşturmanız isteniyor.
        Aşağıdaki gereksinimlere uygun bir testi yazın:

         * https://reqres.in/api/users URL'sine bir POST isteği gönderin.
         * İstek için JSON formatında şu bilgileri içeren bir body kullanın:
                { "name": "morpheus", "job": "leader" }
         * Gelen yanıtın durum kodunun 201 olduğunu doğrulayın.
         * Yanıtın JSON body'sinde name alanının morpheus olduğunu kontrol edin.

 */

    @Test
    public void testCreateUser() {
        // Base URL
        String baseUrl = "https://reqres.in/api/users";

        // POST isteği için body
        JSONObject requestBody=new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","leader");
      //  String requestBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        // POST isteği yap ve yanıtı al
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(baseUrl);

        response.prettyPrint();

        // Durum kodunu doğrula
        assertEquals(201, response.getStatusCode(), "Status code is incorrect!");

        // Oluşturulan kullanıcının adını doğrula
        String name = response.jsonPath().getString("map.name");
        assertEquals("morpheus", name, "User name is incorrect!");
    }
}

