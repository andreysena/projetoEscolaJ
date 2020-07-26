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
    private int turma;
    private int professor;

    public TurmaProfessor(int turma, int professor) {
        this.turma = turma;
        this.professor = professor;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }
    
    
}
