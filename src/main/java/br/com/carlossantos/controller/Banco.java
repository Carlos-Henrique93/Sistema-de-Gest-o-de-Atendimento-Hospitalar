package br.com.carlossantos.controller;

import br.com.carlossantos.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Medico> pesquisaTodosMedicos(Connection conexao){
        List<Medico> medicos = new ArrayList<>();
        String sql = "select * from medico";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Medico medico =  new Medico();
            medico.setId(rs.getInt("id"));
            medico.setNome(rs.getString("nome"));
            medico.setCrm(rs.getString("crm"));

            medicos.add(medico);

        }
        rs.close();
        stmt.close();

        } catch (SQLException e) {
            System.out.println("Erro ao Listar os cadastros dos Medicos!");
            e.printStackTrace();
        }
        return medicos;
    }

    public void detetarMedico(int id, Connection conexao){
        String sql = "delete from medico where id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultado = stmt.executeUpdate();

            if(resultado>0){
                System.out.println("Medico deletado com sucesso!");
            }else {
                System.out.println("Nenhum medico encontrado com ID informado!");
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel deletar medico pelo ID");
            e.printStackTrace();
        }

    }

    public void detetarMedicoCrm(String crm, Connection conexao){
        String sql = "delete from medico where crm = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, crm);
            int resultado = stmt.executeUpdate();

            if(resultado>0){
                System.out.println("Medico deletado com sucesso!");
            }else {
                System.out.println("Nenhum medico encontrado com CRM informado!");
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel deletar medico pelo CRM");
            e.printStackTrace();
        }
    }
    public Medico pesquisarMedico (String crm, Connection conexao){
     String sql = "select id,nome,crm from medico where crm = ?";
        Medico medico = new Medico();

     try {
      PreparedStatement stmt = conexao.prepareStatement(sql);
      stmt.setString(1, crm);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()){
          int id = rs.getInt("id");
          String nome = rs.getString("nome");
          String crm2 = rs.getString("crm");
          medico = new Medico();
          medico.setId(id);
          medico.setNome(nome);
          medico.setCrm(crm2);

          rs.close();
          stmt.close();
      }
     } catch (SQLException e) {
         System.out.println("Erro ao pesquisar o Medico pelo CRM" + e.getMessage());
         e.printStackTrace();
     }
     return medico;
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
