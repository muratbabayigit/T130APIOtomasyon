package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C1_Get_ApiSorgulama {
/*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8, ve
    Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK
    ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */
    // API Testlerinde 4 işlem ile test yapılır
    /*
        1-EndPoint belirlenir
        2-Gerekli ise Expected Data Hazırlanır
        3-Actual Data kaydedilir
        4-Assertion işlemi gerçekleştirilir
     */
    @Test
    public void get01(){

        //1-EndPoint belirlenir
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2-Gerekli ise Expected Data Hazırlanır

        //3-Actual Data kaydedilir
        Response response=given().when().get(url);

        //Assertion İşlemi(Bu test için manuel yapmamız istenmiş)

        //System.out.println(response.prettyPrint());
        System.out.println("Status Code: "+response.getStatusCode()); //200
        System.out.println("Content Type: "+response.getContentType()); //application/json; charset=utf-8
        System.out.println("Server: "+response.getHeader("Server")); //Cowboy
        System.out.println("Status Line: "+response.getStatusLine());//HTTP/1.1 200 OK
        System.out.println("Test time: "+response.getTime()+" ms"); // testTime<5s



    }




}
