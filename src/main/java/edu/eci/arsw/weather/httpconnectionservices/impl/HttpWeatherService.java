package edu.eci.arsw.weather.httpconnectionservices.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.httpconnectionservices.IHttpWeatherService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HttpWeatherService implements IHttpWeatherService {

    @Override
    public JSONObject getWeatherByCity(String name) throws UnirestException {
        HttpResponse<String> response = Unirest
                .get("https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=2cfcdcb02b8d59b74199759faf53b6ed")
                .asString();
        return new JSONObject(response.getBody());
    }
}
