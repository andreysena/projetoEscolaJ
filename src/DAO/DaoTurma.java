/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoTurma {
    
    private Connection connection =  new ConnectionFactory.Connection().getConnection();
    
    public void adicionar(Turma turma){
        String sql = "insert into turma(letra_turma, FK_Coordenador) values(?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, turma.getLetra_turma());
            stmt.setInt(2, turma.getFkCoordenador());
            
            stmt.execute();
            stmt.close();
           
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
    
        String sql = "select t.ID_Turma, t.letra_turma, f.nome_funcionario, c.ID_Coordenador from turma t\n" +
                     "join coordenador c on ID_Coordenador = FK_Coordenador\n" +
                     "join funcionario f on ID_Funcionario = FK_Func_Coord\n" +
                     "where t.status = 'D' order by ID_Turma;";
        ResultSet rs;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs;
        
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(Turma turma, String id){
        String sql = "update turma set letra_turma = ?, FK_Coordenador = ? where ID_Turma = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, turma.getLetra_turma());
            stmt.setInt(2, turma.getFkCoordenador());
            stmt.setInt(3, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update turma set status = 'I' where ID_Turma = ?";
        
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
