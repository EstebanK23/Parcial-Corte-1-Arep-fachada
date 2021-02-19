package edu.escuelaing.arep;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Fachada {

    public static JSONObject direccion(String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get(url).asString();
        return new JSONObject(response.getBody());
    }

}
