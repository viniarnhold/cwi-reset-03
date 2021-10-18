package br.com.cwi.reset.viniciusarnhold.exceptions;

public class NomeESobrenomeException extends Exception{

    public NomeESobrenomeException() {
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
