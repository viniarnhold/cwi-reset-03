package br.com.cwi.reset.viniciusarnhold.exceptions;

public class EstudioEncontradoException extends Exception{
    public EstudioEncontradoException(String nome) {
        super("Já existe um estúdio cadastrado para o nome " + nome);
    }
}
