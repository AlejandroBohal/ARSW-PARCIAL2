const app = (() =>{
    const mapWeatherToObject = (weatherStats) =>{
        let table1 = $("#weather > tbody");
        let table2 = $("#otherStats > tbody");
        let table3 = $("#mainStats > tbody");
        let table0 = $("#cityinfo > tbody");
        let wd = weatherStats.data;
        table0.empty();
        table1.empty();
        table2.empty();
        table3.empty();
        table0.append(
            `<tr> 
                      <td>${wd.name}</td>
                      <td>${wd.timezone}</td>
                      <td>${wd.visibility}</td>
                </tr>`
        );
        table1.append(
            `<tr> 
                      <td>${wd.weather.main}</td>
                      <td>${wd.weather.description}</td>
                </tr>`
        );
        table2.append(
            `<tr><td>Temperature</td><td>${wd.mainStats.temp}</td></tr>
             <tr><td>Min temp</td><td>${wd.mainStats.temp_min}</td></tr>
             <tr><td>Max temp</td><td>${wd.mainStats.temp_max}</td></tr>
            <tr><td>Presure</td><td>${wd.mainStats.pressure}</td></tr>
            <tr><td>humidity</td><td>${wd.mainStats.humidity}</td></tr>`
        );
        table3.append(
            `<tr><td>Wind speed</td><td>${wd.wind.speed}</td></tr>
             <tr><td>Wind deg</td><td>${wd.wind.deg}</td></tr>
             `
        );

    }
    const getWeatherByCity = (city) =>{
        weatherservice.getWeatherByCity(city,mapWeatherToObject);
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();
