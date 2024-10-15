package newTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiListTest_GET {

    @Test
    public void testGetUserList() {
        // Base URL
        String baseUrl = "https://reqres.in/api/users?page=2";

        // GET isteği yap ve yanıtı al
        Response response = RestAssured.get(baseUrl);

        response.prettyPrint();

        // Durum kodunu doğrula
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is incorrect!");

        // Liste içindeki kullanıcı sayısının en az 1 olduğunu doğrula
        int userCount = response.jsonPath().getList("data").size();
        Assert.assertTrue(userCount > 0, "User list is empty!");

        // İlk kullanıcının email'inin boş olmadığını doğrula
        String firstUserEmail = response.jsonPath().getString("data[0].email");
        Assert.assertNotNull(firstUserEmail, "First user's email is null!");
        Assert.assertFalse(firstUserEmail.isEmpty(), "First user's email is empty!");
    }
}
