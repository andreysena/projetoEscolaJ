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
public class Aluno {
    private String nome;
    private String numeroMatricula;
    private String dtNascimento;
    private String telefone;
    private String cpf;
    private String rg;
    private int FkTurma;

    public Aluno(String nome, String numeroMatricula, String dtNascimento, String telefone, String cpf, String rg, int FkTurma) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.FkTurma = FkTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getFkTurma() {
        return FkTurma;
    }

    public void setFkTurma(int FK_Turma) {
        this.FkTurma = FK_Turma;
    }

   
}
