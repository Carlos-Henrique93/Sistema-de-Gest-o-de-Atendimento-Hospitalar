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


        Medico medico = new Medico("Maria Camargo Santos","1010");
        medico.setId(5);
        banco.atualizarMedico(medico,conexao);
       // banco.adicionarMedico(medico, conexao);

        banco.desconectar(conexao);
        }
    }
