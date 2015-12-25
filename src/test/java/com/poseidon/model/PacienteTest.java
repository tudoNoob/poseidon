package com.poseidon.model;

import org.joda.time.LocalDate;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PacienteTest {

	@Test
	public void deveCriarUmPaciente() {
		LocalDate localDate = new LocalDate(1999,10,10);
		Paciente paciente = new Paciente(1,"joao",localDate,"joao.t@email.com","9182737","098098098");
        assertThat(paciente.getId(),is(1));
        assertThat(paciente.getNome(), is("joao"));
        assertThat(paciente.getEmail(), is("joao.t@email.com"));
        assertThat(paciente.getTelefone(), is("9182737"));
        assertThat(paciente.getCpf(), is("098098098"));

    }

}
