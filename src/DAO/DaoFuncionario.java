/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class DaoFuncionario {
    
    private Connection connection = ConnectionFactory.Connection.getConnection();
    
    public void adicionar(Funcionario funcionario){
        String sql = "insert into funcionario(nome_funcionario, dt_nasc, cpf, rg, telefone, salario) \n"
                + "values(?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getDtNascimento());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getRg());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setDouble(6, funcionario.getSalario());
            
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public ResultSet listar(){
        String sql = "select * from funcionario where status = 'D'";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            return rs;
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void alterar(Funcionario funcionario, String id){
        String sql = "update funcionario set nome_funcionario = ?, dt_nasc = ?, cpf = ?, rg = ?, telefone = ?, salario = ? \n"
                    +"where ID_Funcionario = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getDtNascimento());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getRg());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setDouble(6, funcionario.getSalario());
            stmt.setInt(7, Integer.parseInt(id));
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
    
    public void excluir(int id){
        String sql = "update funcionario set status = 'I' where ID_Funcionario = ?";
        
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
