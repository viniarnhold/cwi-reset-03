package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorCadastradoException extends Exception{

    public AtorCadastradoException(String ator) {
        super("Já existe um ator cadastrado para o nome " + ator + ".");
    }
}
