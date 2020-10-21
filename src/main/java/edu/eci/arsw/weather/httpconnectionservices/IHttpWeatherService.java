package edu.eci.arsw.weather.httpconnectionservices;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public interface IHttpWeatherService {
    public JSONObject getWeatherByCity(String name) throws UnirestException;
}
