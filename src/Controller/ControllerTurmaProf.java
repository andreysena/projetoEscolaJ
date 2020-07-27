/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoTurmaProfessor;
import Model.TurmaProfessor;
import View.TurmaProfessor.Cad_TurmaProfessor;

/**
 *
 * @author andrey
 */
public class ControllerTurmaProf {
 
    private final Cad_TurmaProfessor vCadTurmaProf;
    DaoTurmaProfessor daoTurmaProf = new DaoTurmaProfessor();

    public ControllerTurmaProf(Cad_TurmaProfessor vCad_TurmaProf) {
        
        this.vCadTurmaProf = vCad_TurmaProf;
    }
    
    public void verificar(int FkTurmaProf, int FkProfTurma){
        if(FkTurmaProf < 1 || FkProfTurma < 1) {
            vCadTurmaProf.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.TurmaProfessor turmaProf = new TurmaProfessor(FkTurmaProf, FkProfTurma);
            
           //String id = cod;
            
           daoTurmaProf.adicionar(turmaProf);
            
           vCadTurmaProf.exibeMensagem("Aluno cadastrado com sucesso!");
           vCadTurmaProf.dispose(); 
        }
    }
    public void alterar(int FkTurmaProf, int FkProfTurma, String cod){
	if(FkTurmaProf < 1 || FkProfTurma < 1) {
            
            vCadTurmaProf.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.TurmaProfessor turmaProf = new TurmaProfessor(FkTurmaProf, FkProfTurma);
           String id = cod;          
  
           daoTurmaProf.alterar(turmaProf, cod);
            
           vCadTurmaProf.exibeMensagem("Aluno alterado com sucesso!");
           vCadTurmaProf.dispose(); 
        }
	
    }
}
