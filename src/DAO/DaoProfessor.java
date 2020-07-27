/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoProfessor {
    
    private Connection connection =  new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Professor professor){
        String sql = "insert into professor(numero_aulas, FK_Func_Prof) values(?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, professor.getNumeroAulas());
            stmt.setInt(2, professor.getFkFuncProf());
            
            stmt.execute();
            stmt.close();
           
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select p.ID_Professor, p.numero_aulas, f.nome_funcionario  from professor p\n" +
"	join funcionario f on ID_Funcionario = FK_Func_Prof\n" +
"		where p.status = 'D' order by p.ID_Professor";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(Professor professor, String id){
        String sql = "update professor set numero_aulas = ?, FK_Func_Prof = ? where ID_Professor = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, professor.getNumeroAulas());
            stmt.setInt(2, professor.getFkFuncProf());
            stmt.setInt(3, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update professor set status = 'I' where ID_Professor = ?";
        
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
