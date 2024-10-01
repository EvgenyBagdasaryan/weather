package org.wether;

import org.springframework.stereotype.Service;

@Service
public class WeatherFeignService {

    private final WeatherFeignClient weatherFeignClient;

    public WeatherFeignService(WeatherFeignClient weatherFeignClient) {
        this.weatherFeignClient = weatherFeignClient;
    }

    public String getWeather(String city) {
        String apiKey = "800d4b5e670e4f378a951350240110";
        return weatherFeignClient.getWeather(apiKey, city);
    }
}