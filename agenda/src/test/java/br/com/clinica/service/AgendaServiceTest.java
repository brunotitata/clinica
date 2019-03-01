package br.com.clinica.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.clinica.model.PacienteResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testandoAgenda() {

        List<PacienteResource> asList = Arrays.asList(restTemplate.getForObject(
                "http://localhost:9000/buscar/paciente/nome/Bruno",
                PacienteResource[].class));

        System.out.println("#####: " + asList);
    }

}
