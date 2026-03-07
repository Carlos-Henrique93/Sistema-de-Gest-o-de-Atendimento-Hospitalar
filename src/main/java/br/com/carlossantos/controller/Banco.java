package br.com.carlossantos.controller;

import br.com.carlossantos.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private String usuario;
    private String senha;
    private String url;

    public Banco(){

    }

    public Connection conectar(){
        usuario = "root";
        senha = "Bi@925212";
        url = "jdbc:mysql://localhost:3306/hospitalar";

        Connection conectado = null;

        try{
            conectado = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conectado com sucesso!");

        } catch (SQLException ex) {
            System.out.println("Não foi possivel conectar ao banco de dados\n");
        }
        return conectado;
    }

        public void desconectar(Connection conexao) throws SQLException {
        conexao.close();
        }

        public void adicionarMedico(Medico medico,Connection conexao){

        }

        public void adicionarPaciente(Paciente paciente, Connection conexao){

        }

        public void adicionarEndereco(Endereco endereco, Connection conexao){

        }

        public void adicionarTelefone(Telefone telefone, Connection conexao){

        }
        public void adicionarAtendimento(Atendimento atendimento, Connection conexao){

        }
}
