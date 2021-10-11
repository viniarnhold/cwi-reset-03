package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;

import java.time.LocalDate;

public class Ator extends ProfissionalCinema{

    private StatusCarreira statusCarreira;

    public Ator(Integer id, String name, LocalDate dataNascimento,
                Integer anoInicioAtividade, StatusCarreira statusCarreira) {
        super(id, name, dataNascimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }

}
