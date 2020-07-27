/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoAluno;
import Model.Aluno;
import View.Aluno.Cad_Aluno;

/**
 *
 * @author Natan G. de Abreu
 */
public class ControllerAluno {
    
    private final Cad_Aluno vCadAluno;
    DaoAluno daoAluno = new DaoAluno();

    public ControllerAluno(Cad_Aluno vCad_Aluno) {
        
        this.vCadAluno = vCad_Aluno;
    }
    
    public void verificar(String nome, String numeroMatricula, String dtNascimento, String telefone, String cpf, String rg, int FkTurma){
        if(nome.equals("") || numeroMatricula.equals("") || dtNascimento.equals("")
                || telefone.equals("") || cpf.equals("") || rg.equals("") || FkTurma < 1) {
            vCadAluno.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Aluno aluno = new Aluno(nome, numeroMatricula, dtNascimento, telefone, cpf, rg, FkTurma);
            
           //String id = cod;
            
           daoAluno.adicionar(aluno);
            
           vCadAluno.exibeMensagem("Aluno cadastrado com sucesso!");
           vCadAluno.dispose(); 
        }
    }
    public void alterar(String nome, String numeroMatricula, String dtNascimento, String telefone, String cpf, String rg, int FkTurma, String cod){
	if(nome.equals("") || numeroMatricula.equals("") || dtNascimento.equals("") || telefone.equals("") || cpf.equals("") || rg.equals("") || FkTurma < 1) {
            
            vCadAluno.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Aluno aluno = new Aluno(nome, numeroMatricula, dtNascimento, telefone, cpf, rg, FkTurma);           
           String id = cod;          
  
           daoAluno.alterar(aluno, cod);
            
           vCadAluno.exibeMensagem("Aluno alterado com sucesso!");
           vCadAluno.dispose(); 
        }
	
    }
}

