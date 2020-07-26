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
public class ProfessorMateria {
    private int professor;
    private int materia;

    public ProfessorMateria(int professor, int materia) {
        this.professor = professor;
        this.materia = materia;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }
    
    
}
