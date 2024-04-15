package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ResponseBilgileriAssertion {
       /*
    https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
    gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8
    Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
 */
    @Test
    public void get02(){

       //1-EndPoint belirlenir
         String url="https://restful-booker.herokuapp.com/booking/10";
       //2-Gerekli ise Expected Data Hazırlanır

       //3-Actual Data kaydedilir
        Response response=given().when().get(url);

       //4-Assertion işlemi gerçekleştirilir
        response.then().assertThat()
                                .statusCode(200)
                                .contentType("application/json; charset=utf-8")
                                .statusLine("HTTP/1.1 200 OK")
                                .header("Server","Cowboy");

}








}
