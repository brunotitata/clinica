package br.com.clinica.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaService {

    private RestTemplate restTemplate;

    public ConsultaService(RestTemplate restTemplate) {
	this.restTemplate = restTemplate;
    }

    private AgendaResource urlAgendaService(String nome) {
	restTemplate.getForObject("http://localhost:9001/", responseType)

    }

}
