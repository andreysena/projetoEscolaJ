/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoMateria;
import Model.Materia;
import View.Materia.Cad_Materia;
import View.Materia.List_Materia;

/**
 *
 * @author andrey
 */
public class ControllerMateria {

    private final Cad_Materia vCadMat;
    DaoMateria daoMat = new DaoMateria();

    public ControllerMateria(Cad_Materia vCad_Mat) {
        
        this.vCadMat = vCad_Mat;
    }
    
    public void verificar(String nome_materia){
        if(nome_materia.equals("") ) {
            vCadMat.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Materia mat = new Materia(nome_materia);
            
           //String id = cod;
            
           daoMat.adicionar(mat);
            
           vCadMat.exibeMensagem("Matétia cadastrada com sucesso!");
           vCadMat.dispose(); 
        }
    }
    public void alterar(String nome_materia, String cod){
	if(nome_materia.equals("")) {
            
            vCadMat.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Materia mat = new Materia(nome_materia);
           String id = cod;          
  
           daoMat.alterar(mat, cod);
            
           List_Materia listMat = new List_Materia();
           listMat.carregarLista();
           vCadMat.exibeMensagem("Matéria alterada com sucesso!");
           vCadMat.dispose(); 
        }
	
    }
}
