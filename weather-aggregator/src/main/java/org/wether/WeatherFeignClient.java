package org.wether;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "https://api.weatherapi.com/v1")
public interface WeatherFeignClient {

    @GetMapping("/current.json")
    String getWeather(@RequestParam("key") String apiKey, @RequestParam("q") String city);
}
