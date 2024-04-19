package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_TestDataJsonPlaceDinamik extends BaseUrlJsonPlaceHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/65 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200 olduğunu
            Connection Header değerinin keep-alive olduğunu
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
             "userId": 7,
             "id": 65,
             "title": "consequatur id enim sunt et et",
             "body": "voluptatibus ex esse\nsint explicabo est aliquid cumque adipisci fuga repellat labore\nmolestiae corrupti ex saepe at asperiores et perferendis\nnatus id esse incidunt pariatur"
        }
     */
    @Test
    public void test02(){
         //1
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","65");

        //2-ExpBody oluştur
        JSONObject expBody= JsonPlaceData.JsonDataOlustur(7,65,"consequatur id enim sunt et et","voluptatibus ex esse\nsint explicabo est aliquid cumque adipisci fuga repellat labore\nmolestiae corrupti ex saepe at asperiores et perferendis\nnatus id esse incidunt pariatur");

         //3-
        Response response=given().when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");

        //4-
        JsonPath resJP=response.jsonPath();

        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));
        assertEquals(expBody.getInt("userId"),resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"),resJP.getInt("id"));
        assertEquals(expBody.getString("title"),resJP.getString("title"));
        assertEquals(expBody.getString("body"),resJP.getString("body"));




    }

}
