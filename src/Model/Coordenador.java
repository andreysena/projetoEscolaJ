/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Natan G. de Abreu
 */
public class Coordenador {
    private int FkFuncCoord;

    public Coordenador(int FkFuncCoord) {
        this.FkFuncCoord = FkFuncCoord;
    }

    public int getFkFuncCoord() {
        return FkFuncCoord;
    }

    public void setFkFuncCoord(int funcionario) {
        this.FkFuncCoord = funcionario;
    }
    
    
}
