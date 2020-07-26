/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TurmaProfessor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoTurmaProfessor {
    
    private Connection connection =  new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(TurmaProfessor turmaProf){
        String sql = "insert into turma_professor(FK_Turma_Prof, FK_Prof_Turma) values(?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, turmaProf.getFkTurmaProf());
            stmt.setInt(2, turmaProf.getFkProfTurma());
            
            stmt.execute();
            stmt.close();
           
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select * from turma_professor where status = 'D'";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(TurmaProfessor turmaProf, String id){
        String sql = "update turma_professor set FK_Turma_Prof = ?, FK_Prof_Turma = ? where ID_TurmaProf = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, turmaProf.getFkTurmaProf());
            stmt.setInt(2, turmaProf.getFkProfTurma());
            stmt.setInt(3, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update turma_professor set status = 'I' where ID_TurmaProf = ?";
        
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
