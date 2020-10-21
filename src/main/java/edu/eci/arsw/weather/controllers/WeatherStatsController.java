package edu.eci.arsw.weather.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.entities.CityWeather;
import edu.eci.arsw.weather.services.IWeatherStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WeatherStatsController {
    @Autowired
    private IWeatherStatsService weatherStatsService;
    @GetMapping("/weather/{cityName}")
    public ResponseEntity<?> getWeatherByCity(@PathVariable String cityName){
        Map<String,String> error= new HashMap<>();
        try{
            CityWeather data = weatherStatsService.getStatsByCity(cityName);
            System.out.println(data);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (UnirestException e){
            error.put("error", e.getMessage());
            return  new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
        }
    }
}
