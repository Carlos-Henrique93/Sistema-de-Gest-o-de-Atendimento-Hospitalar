package br.com.carlossantos;


import br.com.carlossantos.controller.Banco;
import br.com.carlossantos.model.Atendimento;
import br.com.carlossantos.model.Medico;
import br.com.carlossantos.model.Paciente;
import br.com.carlossantos.model.Telefone;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Banco banco = new Banco();
        Connection conexao = banco.conectar();

        List<Medico> medicos = banco.pesquisaTodosMedicos(conexao);
        banco.desconectar(conexao);

        for (int i=0;i<medicos.size();i++) {
            Medico m = medicos.get(i);
            System.out.println(m.getId() + " - " + m.getNome()+ " - "+ m.getCrm());
        }
    }
}
