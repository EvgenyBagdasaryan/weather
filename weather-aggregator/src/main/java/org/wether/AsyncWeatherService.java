package org.wether;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
//@RequiredArgsConstructor
public class AsyncWeatherService {

    private final RestTemplate restTemplate;

    public AsyncWeatherService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<String> getWeatherAsync(String city) {
        String url = "https://api.weatherapi.com/v1/current.json?key=800d4b5e670e4f378a951350240110&q=" + city;
        String result = restTemplate.getForObject(url, String.class);
        return CompletableFuture.completedFuture(result);
    }
}