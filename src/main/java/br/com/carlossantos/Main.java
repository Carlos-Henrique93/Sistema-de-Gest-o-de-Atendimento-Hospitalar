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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Banco banco = new Banco();
        Connection conexao = banco.conectar();

        List<Medico> medicos = banco.pesquisaTodosMedicos(conexao);

        for (int i=0;i<medicos.size();i++) {
            Medico m = medicos.get(i);
            System.out.println(m.getId() + " - " + m.getNome()+ " - "+ m.getCrm());
        }
        System.out.println("*****************");
        System.out.println("SISTEMA DE SAUDE");
        System.out.println("*****************");
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o ID do Medico que deseja deletar: ");
        int id = input.nextInt();

       banco.detetarMedico(id,conexao);
       banco.desconectar(conexao);
    }
}
