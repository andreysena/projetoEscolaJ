/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ProfessorMateria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoProfessorMateria {
    
    private Connection connection =  new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(ProfessorMateria profMat){
        String sql = "insert into professor_materia(FK_Prof_Mat, FK_Materia) values(?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, profMat.getFkProfMat());
            stmt.setInt(2, profMat.getFkMateria());
            
            stmt.execute();
            stmt.close();
           
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select pm.ID_ProfMat, f.nome_funcionario, pm.FK_Prof_Mat, m.nome_materia, pm.FK_Materia from professor_materia pm\n" +
                     "join materia m on ID_Materia = FK_Materia\n" +
                     "join professor p on ID_Professor = FK_Prof_Mat \n" +
                     "join funcionario f on ID_Funcionario = FK_Func_Prof\n"+
                     "where pm.status = 'D'";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(ProfessorMateria profMat, String id){
        String sql = "update professor_materia set FK_Prof_Mat = ?, FK_Materia = ? where ID_ProfMat = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, profMat.getFkProfMat());
            stmt.setInt(2, profMat.getFkMateria());
            stmt.setInt(3, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update professor_materia set status = 'I' where ID_ProfMat = ?";
        
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
