/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DaoCoordenador;
import Model.Coordenador;
import View.Coordenador.Cad_Coordenador;
import View.Coordenador.List_Coordenador;

/**
 *
 * @author andrey
 */
public class ControllerCoordenador {
    private final Cad_Coordenador vCadCoord;
    DaoCoordenador daoCoord = new DaoCoordenador();

    public ControllerCoordenador(Cad_Coordenador vCad_Coord) {
        
        this.vCadCoord = vCad_Coord;
    }
    
    public void verificar(int FkFuncCoord){
        if(FkFuncCoord < 1) {
            vCadCoord.exibeMensagem("Preencha todos os campos para realizar o cadastro!");
    	}else{
           Model.Coordenador coord = new Coordenador(FkFuncCoord);
            
           //String id = cod;
            
           daoCoord.adicionar(coord);
            
           vCadCoord.exibeMensagem("Coordenador cadastrado com sucesso!");
           vCadCoord.dispose(); 
        }
    }
    public void alterar(int FkFuncCoord, String cod){
	if(FkFuncCoord < 1) {
            
            vCadCoord.exibeMensagem("Preencha todos os campos para realizar a alteração!");
    	}else{
           Model.Coordenador coord = new Coordenador(FkFuncCoord);
           String id = cod;          
  
           daoCoord.alterar(coord, cod);
            
           List_Coordenador listaCoord = new List_Coordenador();
           listaCoord.carregarLista();
           vCadCoord.exibeMensagem("Coordenador alterado com sucesso!");
           vCadCoord.dispose(); 
        }
	
    }
}
