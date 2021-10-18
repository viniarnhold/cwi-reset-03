package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorDataNascimentoException extends Exception{

    public DiretorDataNascimentoException() {
        super("Não é possível cadastrar diretores não nascidos.");
    }
}
