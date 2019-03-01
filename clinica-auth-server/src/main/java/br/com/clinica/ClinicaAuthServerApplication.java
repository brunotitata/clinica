package br.com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClinicaAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaAuthServerApplication.class, args);
    }

}
