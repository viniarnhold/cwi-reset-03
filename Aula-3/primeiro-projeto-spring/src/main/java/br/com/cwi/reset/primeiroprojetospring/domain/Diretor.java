package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, Integer quantidadeDeFilmesDirigidos) {
        super(nome, dataNascimento, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public Integer getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }


}
