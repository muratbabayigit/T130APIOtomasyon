package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
     /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

       {
           "status":"success",
           "data":{
                     "id": 12,
                     "employee_name": "Quinn Flynn",
                     "employee_salary": 342000,
                     "employee_age": 22,
                     "profile_image": ""
                   },
           "message":"Successfully! Record has been fetched."
       }
*/

    @Test
    public void softAssertTesti(){

        //1-Endpoint hazırlama (RequestBody verilirse o da burada hazırlanır)
        String url="http://dummy.restapiexample.com/api/v1/employee/12";

        //2-ExpectedBody Hazırlanır

        JSONObject data=new JSONObject();
        data.put("id",12);
        data.put("employee_name","Quinn Flynn");
        data.put("employee_salary",342000);
        data.put("employee_age",22);
        data.put("profile_image","");

        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",data);
        expBody.put("message","Successfully! Record has been fetched.");

        //3-Dönen response kaydedilir
        Response response=given().when().get(url);

        //4-Assertion yapılır
        JsonPath resJP=response.jsonPath(); //gelen cevap jsonpath türüne çevrilir

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(resJP.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJP.get("message"),expBody.get("message"));

        softAssert.assertAll();




    }

}
