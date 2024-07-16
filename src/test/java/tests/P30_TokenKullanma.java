package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.HerOkuAppData;

import static io.restassured.RestAssured.given;

/*
    https://restful-booker.herokuapp.com/booking/3324 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.
        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */

public class P30_TokenKullanma extends BaseUrlHerOkuApp {

  static String token;
    @Test
    public void tokenCreate(){
        specHerOkuApp.pathParam("pp1","auth");
        JSONObject data = new JSONObject();

        data.put("username","admin");
        data.put("password","password123");

        Response response=given().contentType(ContentType.JSON).when()
                .spec(specHerOkuApp).body(data.toString())
                .header("Content-Type","application/json")
                .post("/{pp1}");

       // response.prettyPrint();
        JsonPath resJP=response.jsonPath();
        token=resJP.getString("token");
       // System.out.println(token);
    }

    @Test
    public void tokenTest2(){
        specHerOkuApp.pathParams("pp1","booking","pp2","3946");
        JSONObject reqBody= HerOkuAppData.reqBodyOlustur();
        Response response=given().contentType(ContentType.JSON)
                .when().spec(specHerOkuApp)
                .body(reqBody.toString())
                .header("Content-Type","application/json")
                .header("Accept", "application/json")
                .header("Cookie","token="+token)
                .put("/{pp1}/{pp2}");

        response.prettyPrint();
    }


}
