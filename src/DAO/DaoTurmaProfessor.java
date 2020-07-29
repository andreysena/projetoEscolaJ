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
    
        String sql = "select tp.ID_TurmaProf, f.nome_funcionario, tp.FK_Prof_Turma, t.letra_turma, tp.FK_Turma_Prof from turma_professor tp\n" +
                     "join turma t on ID_Turma = FK_Turma_Prof\n" +
                     "join professor p on ID_Professor = FK_Prof_Turma\n" +
                     "join funcionario f on ID_Funcionario = FK_Func_Prof\n" +
                        "where tp.status = 'D'";
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
