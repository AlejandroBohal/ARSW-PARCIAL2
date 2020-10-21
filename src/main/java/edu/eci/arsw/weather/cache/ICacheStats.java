package edu.eci.arsw.weather.cache;


import edu.eci.arsw.weather.cache.impl.Tuple;
import edu.eci.arsw.weather.entities.CityWeather;

import java.util.Date;

/**
 * The interface Corona virus stats cache.
 */
public interface ICacheStats {

    /**
     * Put cache.
     *
     * @param name  the name
     * @param stats the stats
     */
    void putCache(String name, CityWeather stats);

    /**
     *     *
     * @param name the name
     * @return the cache
     */
    Tuple<CityWeather, Date> getCache(String name);

    /**
     * Gets date.
     *
     * @param name the name
     * @return the date
     */
    long getDate(String name);
}

