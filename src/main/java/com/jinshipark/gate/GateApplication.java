package com.jinshipark.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GateApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);
    }

}
