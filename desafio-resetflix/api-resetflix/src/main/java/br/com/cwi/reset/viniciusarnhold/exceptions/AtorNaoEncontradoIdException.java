package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorNaoEncontradoIdException extends Exception{

    public AtorNaoEncontradoIdException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
    }
}
