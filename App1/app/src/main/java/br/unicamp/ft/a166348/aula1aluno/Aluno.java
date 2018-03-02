package br.unicamp.ft.a166348.aula1aluno;

/**
 * Created by andre on 02/03/2018.
 */


public class Aluno {
    private String nome;
    private String ra;


    public Aluno(String nome, String ra){
        //this.nome = nome;
        //this.ra = ra;
        this.setNome(nome);
        this.setRa(ra);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Aluno: " + this.nome + " | RA:" + this.ra;
    }



}
