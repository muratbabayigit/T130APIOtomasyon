package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_DeSerializationPUT extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

     Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */


    @Test
    public void deSerializationTest(){
        //1-Endpoint ve ReqBody Hazırlamak
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70"); //Endpoint
        Map<String, Object> reqMapBody= JsonPlaceData.mapBodyOlustur(); //reqBody

        //2-Expected Data Oluşturuldu
        Map<String,Object> expMapBody=  JsonPlaceData.mapBodyOlustur();

        //3-Dönen Response kaydedildi(JSon)
        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                                                           .when().body(reqMapBody).put("/{pp1}/{pp2}");


        //expectedBody <---------> Response Body
        //    Map                      Json

        //Assertion İşlemini yapabilmek için dönen Json response map türüne çevrilir
        //İşte bu olaya deSerialization denir

        Map<String,Object> resMAP=response.as(HashMap.class);  //deSerialization işlemi yapıldı

        assertEquals(expMapBody.get("title"),resMAP.get("title"));
        assertEquals(expMapBody.get("body"),resMAP.get("body"));
        assertEquals(expMapBody.get("id"),resMAP.get("id"));
        assertEquals(expMapBody.get("userId"),resMAP.get("userId"));




    }
}
