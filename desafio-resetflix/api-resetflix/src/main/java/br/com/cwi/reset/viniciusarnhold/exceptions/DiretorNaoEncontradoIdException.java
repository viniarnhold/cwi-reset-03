package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorNaoEncontradoIdException extends Exception{

    public DiretorNaoEncontradoIdException(Integer id) {
        super("Nenhum diretor encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
    }
}
