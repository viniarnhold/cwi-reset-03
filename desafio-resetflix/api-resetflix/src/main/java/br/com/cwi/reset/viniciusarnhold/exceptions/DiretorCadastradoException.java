package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorCadastradoException extends Exception{

    public DiretorCadastradoException(String diretor) {

        super("Já existe um diretor cadastrado para o nome " + diretor + ".");
    }
}
