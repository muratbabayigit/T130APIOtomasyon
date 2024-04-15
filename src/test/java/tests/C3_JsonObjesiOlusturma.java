package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {

      /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.
                     {
                     "title":"Ahmet",
                     "body":"Merhaba",
                     "userId":1
                     }
      */

    @Test
    public void jSonDataOlustur01(){

        JSONObject jSonData=new JSONObject();

        jSonData.put("title","Ahmet");
        jSonData.put("body","Merhaba");
        jSonData.put("userId",1);

        System.out.println("JSON Data Bilgileri: "+jSonData);
    }


    @Test
    public void jSonDataOlustur02(){
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "firstname":"Jim",
        "lastname":"Brown",
        "bookingdates": {
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                         },
         "totalprice":111,
        "depositpaid":true,
        "additionalneeds":"Breakfast"
     }
    */
        JSONObject innerData=new JSONObject();
            innerData.put("checkin","2018-01-01");
            innerData.put("checkout","2019-01-01");

        JSONObject jSonData2=new JSONObject();

            jSonData2.put("firstname","Jim");
            jSonData2.put("lastname","Brown");
            jSonData2.put("bookingdates",innerData);
            jSonData2.put("totalprice",111);
            jSonData2.put("depositpaid",true);
            jSonData2.put("additionalneeds","Breakfast");

        System.out.println("2. JSon Data: "+jSonData2);

    }

}
