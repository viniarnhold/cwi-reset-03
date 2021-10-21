package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EstudioNaoEncontradoIdException extends Exception{

    public EstudioNaoEncontradoIdException(Integer id) {
        super("Nenhum estúdio encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
    }
}