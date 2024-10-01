package org.wether;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1")
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherFeignService weatherFeignService;
    private final AsyncWeatherService asyncWeatherService;

    public WeatherController(WeatherService weatherService,
                             WeatherFeignService weatherFeignService,
                             AsyncWeatherService asyncWeatherService) {
        this.weatherService = weatherService;
        this.weatherFeignService = weatherFeignService;
        this.asyncWeatherService = asyncWeatherService;
    }

    // Вызов через RestTemplate
    @GetMapping("/weather/rest")
    public String getWeatherWithRestTemplate(@RequestParam String city) {
        return weatherService.getWeather(city);
    }

    // Вызов через FeignClient
    @GetMapping("/weather/feign")
    public String getWeatherWithFeign(@RequestParam String city) {
        return weatherFeignService.getWeather(city);
    }

    // Асинхронный вызов
    @GetMapping("/weather/async")
    public CompletableFuture<String> getWeatherAsync(@RequestParam String city) {
        return asyncWeatherService.getWeatherAsync(city);
    }
}