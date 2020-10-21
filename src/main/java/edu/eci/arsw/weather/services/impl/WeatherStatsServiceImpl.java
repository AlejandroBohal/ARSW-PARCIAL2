package edu.eci.arsw.weather.services.impl;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.*;
import edu.eci.arsw.weather.httpconnectionservices.IHttpWeatherService;
import edu.eci.arsw.weather.services.IWeatherStatsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherStatsServiceImpl implements IWeatherStatsService {
    @Autowired
    private IHttpWeatherService weatherService;
    @Override
    public CityWeather getStatsByCity(String name) throws UnirestException {
        CityWeather cityWeather = new CityWeather();
        JSONObject object = weatherService.getWeatherByCity(name);
        Coord coord = formatObject("coord",object,Coord.class);
        Clouds clouds = formatObject("clouds",object,Clouds.class);
        MainStats mainStats = formatObject("main",object,MainStats.class);
        JSONObject objectWeather = object.getJSONArray("weather").getJSONObject(0);
        Weather weather = mapWeather(objectWeather);
        setCityWeatherStats(cityWeather,coord,clouds,mainStats,weather,object);
        return null;
    }

    private Weather mapWeather(JSONObject objectWeater) {
        Gson gson = new Gson();
        return gson.fromJson(objectWeater.toString(),Weather.class);
    }
    private <T> T formatObject(String objectName, JSONObject object, Class objectClass){
        Gson gson = new Gson();
        String stringObject =  object.getJSONObject(objectName).toString();
        T formattedObject = (T) gson.fromJson(stringObject,objectClass);
        return formattedObject;
    }
    private void setCityWeatherStats(CityWeather cityWeather, Coord coord, Clouds clouds, MainStats mainStats, Weather weather, JSONObject object) {
        cityWeather.setCoord(coord);
        cityWeather.setWeather(weather);
        cityWeather.setMainStats(mainStats);
        cityWeather.setClouds(clouds);
        cityWeather.setName(object.getString("name"));
        cityWeather.setTimezone(object.getInt("timezone"));
        cityWeather.setCod(object.getInt("cod"));
        cityWeather.setVisibility(object.getInt("visibility"));


    }
}
