package tests;

import baseUrl.BaseurlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_DeSerializationGET extends BaseurlDummy {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
         Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,f
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void GetDeSTest(){
        specDummy.pathParams("pp1","employee","pp2","3");
        Map<String,Object> expMapBody= DummyData.mapBodyOlustur();
        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        Map<String,Object> resMap=response.as(HashMap.class); //bir map objesinin içine cevabın map'e döndürülmüş halini ekledik

       assertEquals(DummyData.contentType,response.getContentType());
       assertEquals(DummyData.basariliSC,response.getStatusCode());
       assertEquals(expMapBody.get("status"),resMap.get("status"));
       assertEquals(expMapBody.get("message"),resMap.get("message"));

       assertEquals(((Map)expMapBody.get("data")).get("id"),((Map)resMap.get("data")).get("id"));
       assertEquals(((Map)expMapBody.get("data")).get("employee_name"),((Map)resMap.get("data")).get("employee_name"));
       assertEquals(((Map)expMapBody.get("data")).get("employee_salary"),((Map)resMap.get("data")).get("employee_salary"));
       assertEquals(((Map)expMapBody.get("data")).get("employee_age"),((Map)resMap.get("data")).get("employee_age"));
       assertEquals(((Map)expMapBody.get("data")).get("profile_image"),((Map)resMap.get("data")).get("profile_image"));



    }

}
