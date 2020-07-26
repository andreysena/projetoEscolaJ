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
    private int professor;
    private int turma;
    private int coordTurma;

    public Turma(int professor, int turma, int coordTurma) {
        this.professor = professor;
        this.turma = turma;
        this.coordTurma = coordTurma;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getCoordTurma() {
        return coordTurma;
    }

    public void setCoordTurma(int coordTurma) {
        this.coordTurma = coordTurma;
    }
    
    
}
