package edu.eci.arsw.weather.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.CityWeather;

public interface IWeatherStatsService {
    CityWeather getStatsByCity(String name) throws UnirestException;
}
