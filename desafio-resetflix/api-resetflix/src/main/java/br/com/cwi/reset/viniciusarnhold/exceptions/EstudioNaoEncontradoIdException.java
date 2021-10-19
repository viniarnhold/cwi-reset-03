package br.com.cwi.reset.viniciusarnhold.exceptions;

public class EstudioNaoEncontradoIdException extends Exception{

    public EstudioNaoEncontradoIdException(Integer id) {
        super("Nenhum estúdio encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
    }
}