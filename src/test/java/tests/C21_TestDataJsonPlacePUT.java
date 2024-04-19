package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_TestDataJsonPlacePUT extends BaseUrlJsonPlaceHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */
    @Test
    public void TestDataJsonPlacePUT(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        JSONObject reqBody= JsonPlaceData.JsonDataOlustur(10,70,"Ahmet","Merhaba");
        JSONObject expBody=JsonPlaceData.JsonDataOlustur(10,70,"Ahmet","Merhaba");
        Response response=given().contentType(ContentType.JSON).when().spec(specJsonPlaceHolder)
                                                                      .body(reqBody.toString())
                                                                      .put("/{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));
        assertEquals(JsonPlaceData.contentType,response.getContentType());
        assertEquals(expBody.getString("title"),resJP.getString("title"));
        assertEquals(expBody.getString("body"),resJP.getString("body"));
        assertEquals(expBody.getInt("userId"),resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"),resJP.getInt("id"));



    }
}
