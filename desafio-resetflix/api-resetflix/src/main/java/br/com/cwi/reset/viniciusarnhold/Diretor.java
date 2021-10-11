package br.com.cwi.reset.viniciusarnhold;

import java.time.LocalDate;

public class Diretor extends ProfissionalCinema{
    public Diretor(Integer id, String name, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(id, name, dataNascimento, anoInicioAtividade);
    }
}
