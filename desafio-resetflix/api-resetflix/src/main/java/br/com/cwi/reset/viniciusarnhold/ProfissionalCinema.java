package br.com.cwi.reset.viniciusarnhold;

import java.time.LocalDate;

public class ProfissionalCinema {
    private Integer id;
    private String name;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public ProfissionalCinema(Integer id, String name, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }


}
