package br.com.clinica.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.clinica.exception.IllegalArgumentException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteTest {

    @Test
    public void criarPaciente() {

	Paciente cliente = new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32",
		"47.331.419-8", "14530-000", "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148",
		true, true);

	assertEquals("Bruno", cliente.getNome());
	assertEquals(Sexo.MASCULINO, cliente.getSexo());
	assertEquals(LocalDate.of(1991, 03, 15), cliente.getDataDeNascimento());
	assertEquals("384.418.688-32", cliente.getCpf());
	assertEquals("47.331.419-8", cliente.getRg());
	assertEquals("14530-000", cliente.getCep());
	assertEquals("Av José Augusto Mendonça 331", cliente.getEndereco());
	assertEquals("Sumaré", cliente.getBairro());
	assertEquals("Miguelópolis", cliente.getCidade());
	assertEquals("016991034148", cliente.getTelefone());
	assertEquals(true, cliente.getEnviarSms());
	assertEquals(true, cliente.getEnviarEmail());
    }

    @Test
    public void criarPacienteComCampoNomeNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente(null, Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_NOME);

    }

    @Test
    public void criarPacienteComCampoSexoNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", null, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8", "14530-000",
		    "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_SEXO);

    }

    @Test
    public void criarPacienteComCampoDataDeNascimentoNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, null, "384.418.688-32", "47.331.419-8", "14530-000",
		    "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_DATA_DE_NASCIMENTO);

    }

    @Test
    public void criarPacienteComCpfNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), null, "47.331.419-8", "14530-000",
		    "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_CPF);

    }

    @Test
    public void criarPacienteComRgNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", null, "14530-000",
		    "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_RG);

    }

    @Test
    public void criarPacienteComCepNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8", null,
		    "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_CEP);

    }

    @Test
    public void criarPacienteComEnderecoNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", null, "Sumaré", "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_ENDERECO);

    }

    @Test
    public void criarPacienteComBairroNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", "Av José Augusto Mendonça 331", null, "Miguelópolis", "016991034148", true, true);
	}).withMessage(Paciente.ERROR_BAIRRO);

    }

    @Test
    public void criarPacienteComCidadeNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", "Av José Augusto Mendonça 331", "Sumaré", null, "016991034148", true, true);
	}).withMessage(Paciente.ERROR_CIDADE);

    }

    @Test
    public void criarPacienteComTelefoneNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", null, true, true);
	}).withMessage(Paciente.ERROR_TELEFONE);

    }

    @Test
    public void criarPacienteComEnvioSmsNullOuVazioDeveLancarException() {

	assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
	    new Paciente("Bruno", Sexo.MASCULINO, LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8",
		    "14530-000", "Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", null, true);
	}).withMessage(Paciente.ERROR_ENVIO_SMS);

    }

}
