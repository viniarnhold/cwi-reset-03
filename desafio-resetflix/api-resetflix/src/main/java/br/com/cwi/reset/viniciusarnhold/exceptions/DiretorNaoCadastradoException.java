package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorNaoCadastradoException extends Exception{

    public DiretorNaoCadastradoException() {

        super("Nenhum diretor cadastrado, favor cadastar diretor.");
    }
}
