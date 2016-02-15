package com.poseidon.model;

import com.poseidon.utils.PoseidonUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer id_quiropraxista;
	private Integer id_paciente;
	private Double valor;
	private Date horario_consulta;
	private Date data_consulta;

	public Consulta() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_quiropraxista() {
		return id_quiropraxista;
	}

	public void setId_quiropraxista(Integer id_quiropraxista) {
		this.id_quiropraxista = id_quiropraxista;
	}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getHorario_consulta() {
		return horario_consulta;
	}

	public Date getData_consulta() {
		return data_consulta;
	}

	public void setHorario_consulta(Date horario_consulta) {
		this.horario_consulta = horario_consulta;
	}

	public void setData_consulta(Date data_consulta) {
		this.data_consulta = data_consulta;
	}

	public Date getDataConsulta_For_SQL() {
		return PoseidonUtils.convertToDate(data_consulta);
	}

	public Date getHorarioConsulta_For_SQL() {
		return PoseidonUtils.convertToTime(horario_consulta);
	}

}
