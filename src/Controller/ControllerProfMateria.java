/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoProfessorMateria;
import Model.ProfessorMateria;
import View.ProfessorMateria.Cad_ProfessorMateria;

/**
 *
 * @author andrey
 */
public class ControllerProfMateria {
    
    private final Cad_ProfessorMateria vCadProfMat;
    DAO.DaoProfessorMateria daoProfTurma = new DaoProfessorMateria();

    public ControllerProfMateria(Cad_ProfessorMateria vCad_ProfMat) {
        
        this.vCadProfMat = vCad_ProfMat;
    }
    
    public void verificar(int FkProfMat, int FkMateria){
        if(FkProfMat < 1 || FkMateria < 1) {
            vCadProfMat.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.ProfessorMateria profMat = new ProfessorMateria(FkProfMat, FkMateria);
            
           //String id = cod;
            
           daoProfTurma.adicionar(profMat);
            
           vCadProfMat.exibeMensagem("Aluno cadastrado com sucesso!");
           vCadProfMat.dispose(); 
        }
    }
    public void alterar(int FkProfMat, int FkMateria, String cod){
	if(FkProfMat < 1 || FkMateria < 1) {
            
            vCadProfMat.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.ProfessorMateria profMat = new ProfessorMateria(FkProfMat, FkMateria);
           String id = cod;          
  
           daoProfTurma.alterar(profMat, cod);
            
           vCadProfMat.exibeMensagem("Aluno alterado com sucesso!");
           vCadProfMat.dispose(); 
        }
	
    }
}
