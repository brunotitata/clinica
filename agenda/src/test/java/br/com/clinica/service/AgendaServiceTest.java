package br.com.clinica.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.model.PacienteResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaServiceTest {

    @Autowired
    private AgendaService agendaService;

    @Test
    public void testandoAgenda() {

        List<PacienteResource> buscarPaciente = agendaService
                .buscarPaciente("Bruno");

        System.out.println("#####: " + buscarPaciente);
    }

}
