package org.wether;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather(String city) {
        String url = "https://api.weatherapi.com/v1/current.json?key=800d4b5e670e4f378a951350240110&q=" + city;
        return restTemplate.getForObject(url, String.class);
    }
}