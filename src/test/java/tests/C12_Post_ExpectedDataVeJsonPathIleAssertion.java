package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
 /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un bookingid haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */
    @Test
    public void expectedPostBodyTesti(){
        //1-EndPoint ve requestBody hazırlama
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Hasan");
        reqBody.put("lastname" , "Yagmur");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wi-fi");

        //2-ExpectedData hazırlama(responseBody olarak verilmiş)
        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",reqBody);

        //3-DönenResponse kaydedilir
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //4- Assertion İşlemi
        JsonPath respJP=response.jsonPath();

        assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));

    }
}
