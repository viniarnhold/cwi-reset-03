package br.com.cwi.reset.viniciusarnhold.exceptions;

public class EstudioNaoCadastradoException extends Exception{

    public EstudioNaoCadastradoException() {
        super("Nenhum estúdio cadastrado, favor cadastar estúdios.");
    }

    public EstudioNaoCadastradoException(String filtroNome) {
        super("Estúdio não encontrato com o filtro " + filtroNome + " favor informar outro filtro.");
    }
}
