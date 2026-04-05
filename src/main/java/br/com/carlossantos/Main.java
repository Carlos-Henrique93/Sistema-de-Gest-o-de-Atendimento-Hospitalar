package br.com.carlossantos;


import br.com.carlossantos.controller.Banco;
import br.com.carlossantos.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Banco banco = new Banco();
        Connection conexao = banco.conectar();

        //objeto paciente
        Paciente paciente = new Paciente("Lucas de Lima Camargo","43069618890");

        //objeto endereco
        Endereco endereco = new Endereco("Rua Presidente Prudente de Moraes",171,"Centro");

        //ArryList telefone do paciente
        Telefone telefone1 = new Telefone("19981886707");
        Telefone telefone2 = new Telefone("19981886808");
        Telefone telefone3 = new Telefone("19981886909");
        ArrayList<Telefone> telefones = new ArrayList<>();
        telefones.add(telefone1);
        telefones.add(telefone2);
        telefones.add(telefone3);

        banco.adicionar(paciente,endereco,telefones,conexao);
       banco.desconectar(conexao);
    }
}
