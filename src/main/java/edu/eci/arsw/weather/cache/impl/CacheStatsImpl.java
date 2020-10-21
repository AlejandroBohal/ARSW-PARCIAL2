package edu.eci.arsw.weather.cache.impl;

import edu.eci.arsw.weather.cache.ICacheStats;
import edu.eci.arsw.weather.entities.CityWeather;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheStatsImpl implements ICacheStats {

    private ConcurrentHashMap<String, Tuple<CityWeather, Date>> cacheStore;

    public CacheStatsImpl(){
        this.cacheStore = new ConcurrentHashMap<>();
    }

    @Override
    public void putCache(String name, CityWeather stats) {
        cacheStore.put(name, new Tuple<>(stats, new Date()));
    }


    @Override
    public Tuple<CityWeather, Date> getCache(String name) {
        return cacheStore.get(name);
    }

    @Override
    public long getDate(String name) {
        if (this.cacheStore.get(name) != null){
            return cacheStore.get(name).getDate().getTime();
        }else{
            return new Date().getTime();
        }
    }
}
