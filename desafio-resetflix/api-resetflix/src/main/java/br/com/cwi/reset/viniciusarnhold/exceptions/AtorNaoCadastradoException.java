package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorNaoCadastradoException extends Exception{

    public AtorNaoCadastradoException() {
        super("Nenhum ator cadastrado, favor cadastar atores.");
    }
}
