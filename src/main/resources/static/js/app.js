const app = (() =>{
    const mapWeatherToObject = (weatherStats) =>{
        console.log(weatherStats.data)
    }
    const getWeatherByCity = (city) =>{
        weatherservice.getWeatherByCity(city,mapWeatherToObject);
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();
