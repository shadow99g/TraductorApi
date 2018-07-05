/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.model;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jordy
 */
public class Dao {
     public model Traducir(model dl) throws JSONException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        

        try {
            HttpPost request = new HttpPost("https://translation.googleapis.com/language/translate/v2");// creamos la conexion con el API
            StringEntity params = new StringEntity("{\n" +
"  \"q\": \""+dl.getNameFile()+"\",\n" +
"  \"target\": \"es\"\n" +
"}");
            
            request.addHeader("Content-Type", "application/json"); // agrega un nuevo encabezado HTML que le decimos sera un tipo : aplicacion json
            request.addHeader("Authorization", "Bearer " + dl.getToken_acces());// agrega un nuevo encabezado HTML el cual sera de Autorizacion : Bearer Token y añade el Token
            request.setEntity(params); // Obtiene la solicitud de recursos
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
         JSONObject json = new JSONObject(EntityUtils.toString(entity));            
           dl.setResponses(json.getJSONObject("data").getJSONArray("translations").getJSONObject(0).getString("translatedText"));
            
        } catch (IOException ex) {
            throw ex;
        }
         return dl;
}

}
