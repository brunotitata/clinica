package br.com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ClinicaEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaEurekaServerApplication.class, args);
    }

}
