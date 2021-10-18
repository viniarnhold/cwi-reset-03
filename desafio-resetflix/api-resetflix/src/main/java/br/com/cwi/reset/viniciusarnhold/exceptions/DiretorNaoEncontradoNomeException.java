package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorNaoEncontradoNomeException extends Exception{

    public DiretorNaoEncontradoNomeException(String filtroNome) {
        super("Diretor não encontrado com filtro " + filtroNome + ", favor informar outro nome");
    }
}
