package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Filme {
    private String nome;
    private String descrição;
    private Integer duracao;
    private Integer anoDeLancamento;
    private Float avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descrição, Integer duracao,
                 Integer anoDeLancamento, Float avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descrição: " + this.descrição);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Diretor: " + diretor.getNome());

    }

    public String getNome() {
        return nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public Float getAvaliacao() {
        return avaliacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setAvaliacao(Float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
}
