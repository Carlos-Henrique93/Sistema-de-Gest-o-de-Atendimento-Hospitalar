package br.com.carlossantos;


import br.com.carlossantos.controller.Banco;
import br.com.carlossantos.model.Atendimento;
import br.com.carlossantos.model.Medico;
import br.com.carlossantos.model.Paciente;
import br.com.carlossantos.model.Telefone;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        Banco banco = new Banco();
        Connection conexao = banco.conectar();


        Medico medico = new Medico("Diogo Camargo","2026");
        banco.adicionarMedico(medico, conexao);

        banco.desconectar(conexao);
        }
    }
