package edu.eci.arsw.weather.entities;

public class CityWeather {

    private Coord coord;
    private Clouds clouds;
    private MainStats mainStats;
    private Weather weather;
    private Wind wind;
    private String name;
    private int timezone;
    private int visibility;
    private int cod;

    public CityWeather() {
    }

    public CityWeather(Coord coord, Clouds clouds, MainStats mainStats, Weather weather, Wind wind, String name, int timezone, int visibility, int cod) {
        this.coord = coord;
        this.clouds = clouds;
        this.mainStats = mainStats;
        this.weather = weather;
        this.wind = wind;
        this.name = name;
        this.timezone = timezone;
        this.visibility = visibility;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public MainStats getMainStats() {
        return mainStats;
    }

    public void setMainStats(MainStats mainStats) {
        this.mainStats = mainStats;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
