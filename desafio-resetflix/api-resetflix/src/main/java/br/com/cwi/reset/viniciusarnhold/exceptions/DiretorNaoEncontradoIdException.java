package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorNaoEncontradoIdException extends Exception{

    public DiretorNaoEncontradoIdException(Integer id) {
        super("Nenhum diretor encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
    }
}
