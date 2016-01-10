package com.poseidon.model;

import java.util.Date;

import javax.persistence.*;

import com.poseidon.annotation.ValidateString;
import com.poseidon.utils.PoseidonUtils;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer id_medico;
    private Integer id_paciente;
    private Double valor;
    
    @ValidateString
    private Date data_consulta;
    @Transient
    private String data_consultaString;

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
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

    public Date getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getData_consultaString() {
        return PoseidonUtils.convertDateToString(data_consulta);
    }

    public void setData_consultaString(String data_consultaString) {
        this.data_consultaString = data_consultaString;
    }

    public Date getDataConsulta_For_SQL() {
        return PoseidonUtils.convertToDate(data_consulta);
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", id_medico=" + id_medico + ", id_paciente=" + id_paciente + 
                ", valor=" + valor + ", data_consulta=" + data_consulta + ", data_consultaString=" + data_consultaString + '}';
    }



}
