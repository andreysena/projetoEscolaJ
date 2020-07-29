/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import Model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
/**
 *
 * @author andrey
 */
public class DaoAluno {
 
    private Connection connection =  new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Aluno aluno){
        String sql = "insert into aluno(nome_aluno, matricula, dt_nasc, cpf, rg, telefone, FK_Turma) \n"
                   + "values(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getNumeroMatricula());
            stmt.setString(3, aluno.getDtNascimento());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getRg());
            stmt.setString(6, aluno.getTelefone());
            stmt.setInt(7, aluno.getFkTurma());
            
            stmt.execute();
            stmt.close();
           
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select a.ID_Aluno, a.nome_aluno, a.matricula, a.dt_nasc, a.cpf, a.rg, a.telefone, t.letra_turma, a.FK_Turma from aluno a\n" +
                        "join turma t on ID_Turma = FK_Turma\n" +
                            "where a.status = 'D'";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(Aluno aluno, String id){
        String sql = "update aluno set nome_aluno = ?, matricula = ?, dt_nasc = ?, cpf = ?, rg = ?, telefone = ?, FK_Turma = ? \n"
                    +"where ID_Aluno = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getNumeroMatricula());
            stmt.setString(3, aluno.getDtNascimento());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getRg());
            stmt.setString(6, aluno.getTelefone());
            stmt.setInt(7, aluno.getFkTurma());
            stmt.setInt(8, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update aluno set status = 'I' where ID_Aluno = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
}
