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
public class Turma {
    private String letra_turma;
    private int FkCoordenador;
    
    

    public Turma(String letra_turma, int FkCoordenador) {
        this.letra_turma = letra_turma;
        this.FkCoordenador = FkCoordenador;
    }

    public String getLetra_turma() {
        return letra_turma;
    }

    public void setLetra_turma(String letra_turma) {
        this.letra_turma = letra_turma;
    }

    public int getFkCoordenador() {
        return FkCoordenador;
    }

    public void setFkCoordenador(int FkCoordenador) {
        this.FkCoordenador = FkCoordenador;
    }
    
    

   
    
    
}
