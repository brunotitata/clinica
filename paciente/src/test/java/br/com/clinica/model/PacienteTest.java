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

		Paciente cliente = new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA,
				LocalDate.of(1991, 03, 15), "384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000",
				"Av José Augusto Mendonça 331", "Sumaré", "Miguelópolis", "016991034148", EnviarSms.NAO, EnviarEmail.SIM);

		assertEquals("PACIENTE-ID", cliente.getPacienteId().getId());
		assertEquals("Bruno", cliente.getNome());
		assertEquals(Sexo.MASCULINO, cliente.getSexo());
		assertEquals(Raca.PARDA, cliente.getRaca());
		assertEquals(LocalDate.of(1991, 03, 15), cliente.getDataDeNascimento());
		assertEquals("384.418.688-32", cliente.getCpf());
		assertEquals("47.331.419-8", cliente.getRg());
		assertEquals("XXXXXXXXXXXX", cliente.getCartaoNacionalDeSaude());
		assertEquals("14530-000", cliente.getCep());
		assertEquals("Av José Augusto Mendonça 331", cliente.getEndereco());
		assertEquals("Sumaré", cliente.getBairro());
		assertEquals("Miguelópolis", cliente.getCidade());
		assertEquals("016991034148", cliente.getTelefone());
		assertEquals(EnviarSms.NAO, cliente.getEnviarSms());
		assertEquals(EnviarEmail.SIM, cliente.getEnviarEmail());
	}

	@Test
	public void criarPacienteComCampoPacienteIdNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId(null), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(PacienteId.ERROR_PACIENTE_ID);

	}

	@Test
	public void criarPacienteComCampoNomeNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), null, Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_NOME);

	}

	@Test
	public void criarPacienteComCampoSexoNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", null, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_SEXO);

	}

	@Test
	public void criarPacienteComCampoRacaNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, null, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_RACA);

	}

	@Test
	public void criarPacienteComCampoDataDeNascimentoNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, null, "384.418.688-32",
					"47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331", "Sumaré",
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_DATA_DE_NASCIMENTO);

	}

	@Test
	public void criarPacienteComCpfNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					null, "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331", "Sumaré",
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_CPF);

	}

	@Test
	public void criarPacienteComRgNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", null, "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331", "Sumaré",
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_RG);

	}

	@Test
	public void criarPacienteComCartaoNacionalDeSaudeNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", null, "14530-000", "Av José Augusto Mendonça 331", "Sumaré",
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_CARTAO_NACIONAL_DE_SAUDE);

	}

	@Test
	public void criarPacienteComCepNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", null, "Av José Augusto Mendonça 331", "Sumaré",
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_CEP);

	}

	@Test
	public void criarPacienteComEnderecoNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", null, "Sumaré", "Miguelópolis",
					"016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_ENDERECO);

	}

	@Test
	public void criarPacienteComBairroNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331", null,
					"Miguelópolis", "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_BAIRRO);

	}

	@Test
	public void criarPacienteComCidadeNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", null, "016991034148", EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_CIDADE);

	}

	@Test
	public void criarPacienteComTelefoneNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", null, EnviarSms.SIM, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_TELEFONE);

	}

	@Test
	public void criarPacienteComEnvioSmsNullOuVazioDeveLancarException() {

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Paciente(new PacienteId("PACIENTE-ID"), "Bruno", Sexo.MASCULINO, Raca.PARDA, LocalDate.of(1991, 03, 15),
					"384.418.688-32", "47.331.419-8", "XXXXXXXXXXXX", "14530-000", "Av José Augusto Mendonça 331",
					"Sumaré", "Miguelópolis", "016991034148", null, EnviarEmail.SIM);
		}).withMessage(Paciente.ERROR_ENVIO_SMS);

	}

}
