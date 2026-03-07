package br.com.carlossantos.model;

import java.util.ArrayList;

public class Atendimento {

    private Integer id;
    private Integer medico_id;
    private Integer paciente_id;
    private String data_atendimento;



    public Atendimento(Integer medico_id, Integer paciente_id, String data_atendimento) {
        this.id = 0;
        this.medico_id = medico_id;
        this.paciente_id = paciente_id;
        this.data_atendimento = data_atendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Integer medico_id) {
        this.medico_id = medico_id;
    }

    public Integer getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(String data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", medico_id=" + medico_id +
                ", paciente_id='" + paciente_id + '\'' +
                ", data_atendimento='" + data_atendimento + '\'' +
                '}';
    }
}
