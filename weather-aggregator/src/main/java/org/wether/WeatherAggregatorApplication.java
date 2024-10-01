package org.wether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
//@EnableConfigurationProperties
public class WeatherAggregatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherAggregatorApplication.class, args);
    }
}