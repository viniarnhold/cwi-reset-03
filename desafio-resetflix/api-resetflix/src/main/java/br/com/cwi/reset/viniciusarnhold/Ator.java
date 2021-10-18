package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;

import java.time.LocalDate;

public class Ator extends ProfissionalCinema{

    private StatusCarreira statusCarreira;

    public Ator() {
    }

    public Ator(String name, LocalDate dataNascimento,
                Integer anoInicioAtividade, StatusCarreira statusCarreira) {
        super(name, dataNascimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "statusCarreira=" + statusCarreira +
                ", " + super.toString();
    }
}
