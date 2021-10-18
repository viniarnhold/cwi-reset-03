package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorNaoEncontradoNomeException extends Exception{

    public AtorNaoEncontradoNomeException(String filtroNome) {
        super("Ator não encontrado com filtro " + filtroNome + ", favor informar outro nome");
    }
}
