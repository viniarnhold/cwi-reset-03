package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private Integer oscarVencido;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer oscarVencido) {
        super(nome, dataNascimento, genero);
        this.oscarVencido = oscarVencido;
    }

    public Integer getOscarVencido() {
        return oscarVencido;
    }
}
