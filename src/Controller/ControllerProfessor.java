/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoProfessor;
import Model.Professor;
import View.Professor.Cad_Professor;
import View.Professor.List_Professor;
import org.w3c.dom.ls.LSInput;

/**
 *
 * @author andrey
 */
public class ControllerProfessor {
    private final Cad_Professor vCadProf;
    DAO.DaoProfessor daoProf = new DaoProfessor();

    public ControllerProfessor(Cad_Professor vCad_Prof) {
        
        this.vCadProf = vCad_Prof;
    }
    
    public void verificar(String numero_aulas, int FkFuncProf){
        if(numero_aulas.equals("") || FkFuncProf < 1) {
            vCadProf.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Professor prof = new Professor(numero_aulas, FkFuncProf);
            
           //String id = cod;
            
           daoProf.adicionar(prof);
            
           vCadProf.exibeMensagem("Professor cadastrado com sucesso!");
           vCadProf.dispose(); 
        }
    }
    public void alterar(String numero_aulas, int FkFuncProf, String cod){
	if(numero_aulas.equals("") || FkFuncProf < 1) {
            
            vCadProf.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Professor prof = new Professor(numero_aulas, FkFuncProf);
           String id = cod;          
  
           daoProf.alterar(prof, cod);
            

           vCadProf.exibeMensagem("Professor alterado com sucesso!");
           vCadProf.dispose(); 
        }
	
    }
}
