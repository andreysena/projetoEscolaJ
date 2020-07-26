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
public class TurmaProfessor {
    private int FkTurmaProf;
    private int FkProfTurma;

    public TurmaProfessor(int FkTurmaProf, int FkProfTurma) {
        this.FkTurmaProf = FkTurmaProf;
        this.FkProfTurma = FkProfTurma;
    }

    public int getFkTurmaProf() {
        return FkTurmaProf;
    }

    public void setFkTurmaProf(int FkTurmaProf) {
        this.FkTurmaProf = FkTurmaProf;
    }

    public int getFkProfTurma() {
        return FkProfTurma;
    }

    public void setFkProfTurma(int FkProfTurma) {
        this.FkProfTurma = FkProfTurma;
    }
    
    
}
