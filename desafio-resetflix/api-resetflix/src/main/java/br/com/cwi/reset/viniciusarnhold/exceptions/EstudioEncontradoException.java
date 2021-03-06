package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstudioEncontradoException extends Exception{
    public EstudioEncontradoException(String nome) {
        super("Já existe um estúdio cadastrado para o nome " + nome);
    }
}
