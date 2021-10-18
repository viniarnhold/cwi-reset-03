package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeESobrenomeException extends Exception{

    public NomeESobrenomeException() {
        super("Deve ser informado no mínimo nome e sobrenome.");
    }
}
