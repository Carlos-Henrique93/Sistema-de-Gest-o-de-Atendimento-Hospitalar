package br.com.carlossantos.controller;

import br.com.carlossantos.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String sql = "insert into medico (nome,crm) values (?,?)";
        try
        {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());

            int resultado = stmt.executeUpdate();

            if(resultado>0){
                System.out.println("Medico adicionado com sucesso!");
            }

            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            System.out.println("Aconteceu um erro ao adicionar medico no banco de dados!\n");
        }
    }

    public void atualizarMedico(Medico medico,Connection conexao){
        String sql = "update medico set nome = ?, crm = ? where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getId());

            int resultado = stmt.executeUpdate();
            if(resultado>0){
                System.out.println("Medico atualizado com sucesso!");
            } else {
                System.out.println("Medico não encontrado com o ID informado!");
            }
        }catch (SQLException e){
            System.out.println("Aconteceu um erro ao adicionar medico no banco de dados!");
            e.printStackTrace();
        }
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
