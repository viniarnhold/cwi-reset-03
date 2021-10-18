package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtorNaoEncontradoIdException extends Exception{

    public AtorNaoEncontradoIdException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
    }
}
