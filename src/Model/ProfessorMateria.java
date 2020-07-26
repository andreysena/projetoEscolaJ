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
    private int FkProfMat;
    private int FkMateria;

    public ProfessorMateria(int FkProfMat, int FkMateria) {
        this.FkProfMat = FkProfMat;
        this.FkMateria = FkMateria;
    }

    public int getFkProfMat() {
        return FkProfMat;
    }

    public void setFkProfMat(int FkProfMat) {
        this.FkProfMat = FkProfMat;
    }

    public int getFkMateria() {
        return FkMateria;
    }

    public void setFkMateria(int FkMateria) {
        this.FkMateria = FkMateria;
    }
     
    
}
