package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceData {
    /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       content type'nın application/json; charset=utf-8
       Connection isimli Header değerinin keep-alive olduğunu
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
*/
       public static int basariliSC=200;
       public static String contentType="application/json; charset=utf-8";
       public static String header="keep-alive";
       public static String header2="cloudflare";

       public static JSONObject expectedDataOlustur01(){
            JSONObject expData=new JSONObject();
            expData.put("userId",3);
            expData.put("id",22);
            expData.put("title","dolor sint quo a velit explicabo quia nam");
            expData.put( "body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\n" +
                    "expedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
            return expData;
       }

        public static JSONObject JsonDataOlustur(int userId, int id,String title,String body){
        JSONObject expData=new JSONObject();
        expData.put("userId",userId);
        expData.put("id",id);
        expData.put("title",title);
        expData.put("body",body);

        return expData;
        }

        public static Map<String,Object> mapBodyOlustur(){
            Map<String,Object> mapBody=new HashMap<>();
            mapBody.put("title","Ahmet");
            mapBody.put("body","Merhaba");
            mapBody.put("id",70.0);
            mapBody.put("userId",10.0);


            return mapBody;
        }

}
