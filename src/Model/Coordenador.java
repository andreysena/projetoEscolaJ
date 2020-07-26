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
    private String numeroAulas;
    private int funcionario;

    public Coordenador(String numeroAulas, int funcionario) {
        this.numeroAulas = numeroAulas;
        this.funcionario = funcionario;
    }

    public String getNumeroAulas() {
        return numeroAulas;
    }

    public void setNumeroAulas(String numeroAulas) {
        this.numeroAulas = numeroAulas;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
