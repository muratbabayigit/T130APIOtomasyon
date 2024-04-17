package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
/*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine
    asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un
    asagidaki gibi oldugunu test edin.

    Request Body                        Response Body
 {                                  {
    "status": "success",                 "status": "success",
    "data": {                            "data": {
        "name": “Ahmet",                            "name": “Ahmet",
        "salary": "1230",                           "salary": "1230",
        "age": "44",                                "age": "44",
        "id": 40                                    "id": 40
    }                                             }
}                                       "message": "Successfully! Record has been updated."}


 */

    @Test
    public  void softAsssertPostRequestTest(){

        //1-Endpoint ve RequrstBody hazırlama
        String url="https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqData=new JSONObject();
        reqData.put("name","Ahmet");
        reqData.put("salary","1230");
        reqData.put("age","44");
        reqData.put("id",40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",reqData);

        //2-ExpectedBody Hazırlama
        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",reqData);
        expBody.put("message","Successfully! Record has been updated.");

        //3-Dönen response kaydedilir

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        //4-Assertion işlemi yapılır

        JsonPath resJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(resJP.get("data.name"),expBody.getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.salary"),expBody.getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.age"),expBody.getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("message"),expBody.get("message"));



    }
}
