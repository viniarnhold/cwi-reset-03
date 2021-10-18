package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorCadastradoException extends Exception{

    public DiretorCadastradoException(String diretor) {

        super("Já existe um diretor cadastrado para o nome " + diretor + ".");
    }
}
