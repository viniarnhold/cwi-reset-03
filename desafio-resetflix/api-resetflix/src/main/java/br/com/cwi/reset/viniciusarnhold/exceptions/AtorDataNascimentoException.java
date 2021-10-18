package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtorDataNascimentoException extends Exception{

    public AtorDataNascimentoException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}
