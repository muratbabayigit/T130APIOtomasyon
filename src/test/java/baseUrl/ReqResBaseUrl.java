package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class ReqResBaseUrl {
    protected RequestSpecification specReqres;


    @BeforeTest
    public void setUp(){
        specReqres = new RequestSpecBuilder().setBaseUri("https://reqres.in").build();
    }
}
