/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoFuncionario;
import Model.Funcionario;
import View.Funcionario.Cad_Funcionario;

/**
 *
 * @author andrey
 */
public class ControllerFuncionario {
    
    private final Cad_Funcionario vCadFunc;
    DaoFuncionario daoFunc = new DaoFuncionario();

    public ControllerFuncionario(Cad_Funcionario vCadFunc) {
        
        this.vCadFunc = vCadFunc;
    }
    
    public void verificar(String nome, String dt_nasc, String cpf, String rg, String telefone, String salario){
        if(nome.equals("") || dt_nasc.equals("") || cpf.equals("") || rg.equals("") || telefone.equals("") || salario.equals("")) {
            vCadFunc.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Funcionario func = new Funcionario(nome, salario, dt_nasc, telefone, cpf, rg);
            
           //String id = cod;
            
           daoFunc.adicionar(func);
            
           vCadFunc.exibeMensagem("Aluno cadastrado com sucesso!");
           vCadFunc.dispose(); 
        }
    }
    public void alterar(String nome, String dt_nasc, String cpf, String rg, String telefone, String salario, String cod){
	if(nome.equals("") || dt_nasc.equals("") || cpf.equals("") || rg.equals("") || telefone.equals("") || salario.equals("")) {
            
            vCadFunc.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Funcionario func = new Funcionario(nome, salario, dt_nasc, telefone, cpf, rg);
           String id = cod;          
  
           daoFunc.alterar(func, cod);
            
           vCadFunc.exibeMensagem("Aluno alterado com sucesso!");
           vCadFunc.dispose(); 
        }
	
    }
}
