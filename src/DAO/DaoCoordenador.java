/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Coordenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoCoordenador {
    
    private Connection connection = ConnectionFactory.Connection.getConnection();
    
    public void adicionar(Coordenador coordenador){
        String sql = "insert into coordenador(FK_Func_Coord) values(?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, coordenador.getFkFuncCoord());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
        String sql = "select c.ID_Coordenador, f.nome_funcionario, f.ID_Funcionario from coordenador c\n" +
"	join funcionario f on ID_Funcionario = FK_Func_Coord\n" +
"		where c.status = 'D' order by c.ID_Coordenador";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            return rs;
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(Coordenador coordenador, String id){
        String sql = "update coordenador set Fk_Func_Coord = ? where ID_Coordenador = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, coordenador.getFkFuncCoord());
            stmt.setInt(2, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update coordenador set status = 'I' where ID_Coordenador = ?";
        
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
