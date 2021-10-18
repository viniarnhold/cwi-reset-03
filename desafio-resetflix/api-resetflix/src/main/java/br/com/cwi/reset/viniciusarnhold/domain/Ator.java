package br.com.cwi.reset.viniciusarnhold.domain;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;

import java.time.LocalDate;

public class Ator extends ProfissionalCinema{

    private StatusCarreira statusCarreira;

    static int ultimoId = 0;

    public Ator() {
        this.id = ++ultimoId;
    }

    public Ator(String name, LocalDate dataNascimento,
                Integer anoInicioAtividade, StatusCarreira statusCarreira) {
        super(name, dataNascimento, anoInicioAtividade);
        this.id = ++ultimoId;
        this.statusCarreira = statusCarreira;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

}
