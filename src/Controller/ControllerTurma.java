/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoTurma;
import Model.Turma;
import View.Turma.Cad_Turma;

/**
 *
 * @author andrey
 */
public class ControllerTurma {

    private final Cad_Turma vCadTurma;
    DaoTurma daoTurma = new DaoTurma();

    public ControllerTurma(Cad_Turma vCad_Turma) {
        
        this.vCadTurma = vCad_Turma;
    }
    
    public void verificar(String letra_turma, int FkFuncCoord){
        if(letra_turma.equals("") || FkFuncCoord < 1) {
            vCadTurma.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Turma turma = new Turma(letra_turma, FkFuncCoord);
            
           //String id = cod;
            
           daoTurma.adicionar(turma);
            
           vCadTurma.exibeMensagem("Turma cadastrada com sucesso!");
           vCadTurma.dispose(); 
        }
    }
    public void alterar(String letra_turma, int FkFuncCoord, String cod){
	if(letra_turma.equals("") || FkFuncCoord < 1) {
            
            vCadTurma.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Turma turma = new Turma(letra_turma, FkFuncCoord);
           String id = cod;          
  
           daoTurma.alterar(turma, cod);
            
           vCadTurma.exibeMensagem("Turma alterada com sucesso!");
           vCadTurma.dispose(); 
        }
	
    }
}
