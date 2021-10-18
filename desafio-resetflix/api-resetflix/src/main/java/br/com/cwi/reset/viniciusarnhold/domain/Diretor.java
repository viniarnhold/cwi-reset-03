package br.com.cwi.reset.viniciusarnhold.domain;

import java.time.LocalDate;

public class Diretor extends ProfissionalCinema{

    static int ultimoId = 0;

    public Diretor(String name, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(name, dataNascimento, anoInicioAtividade);
        this.id = ++ultimoId;
    }

    public Diretor() {
        this.id = ++ultimoId;
    }


}
