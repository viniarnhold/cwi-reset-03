package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorDataNascimentoException extends Exception{

    public AtorDataNascimentoException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}
