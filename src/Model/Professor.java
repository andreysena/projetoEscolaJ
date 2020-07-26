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
public class Professor {
    private String numeroAulas;
    private int FkFuncProf;

    public Professor(String numeroAulas, int FkFuncProf) {
        this.numeroAulas = numeroAulas;
        this.FkFuncProf = FkFuncProf;
    }

    public String getNumeroAulas() {
        return numeroAulas;
    }

    public void setNumeroAulas(String numeroAulas) {
        this.numeroAulas = numeroAulas;
    }

    public int getFkFuncProf() {
        return FkFuncProf;
    }

    public void setFkFuncProf(int funcionario) {
        this.FkFuncProf = funcionario;
    }
    
    
}
