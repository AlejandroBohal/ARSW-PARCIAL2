const weatherservice = (() =>{
    const getWeatherByCity = (city,callback) =>{
        axios.get('/api/weather/' + city).then(res=>{
            callback(res);
        })
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();
