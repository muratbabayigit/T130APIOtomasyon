package newTest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest_GET {
  /*
        ReqRes API'sini kullanarak, bir kullanıcının ID'sine göre
        bilgilerinin alındığı bir GET isteği yapmanız isteniyor.
            * https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.
            * Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
            * Yanıtın JSON body'sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
            * Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.
   */

    @Test
    public void testGetUser() {
        // Base URL
        String baseUrl = "https://reqres.in/api/users/2";

        // GET isteği yap ve yanıtı al
        Response response = RestAssured.get(baseUrl);

        // Durum kodunu doğrula
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is incorrect!");

        // JSON body içindeki "data.id" alanını doğrula
        int userId = response.jsonPath().getInt("data.id");
        Assert.assertEquals(userId, 2, "User ID is incorrect!");

        // Yanıt süresinin 2 saniyeden kısa olduğunu doğrula
        long responseTime = response.time();
        Assert.assertTrue(responseTime < 2000, "Response time is too slow!");
    }
}
