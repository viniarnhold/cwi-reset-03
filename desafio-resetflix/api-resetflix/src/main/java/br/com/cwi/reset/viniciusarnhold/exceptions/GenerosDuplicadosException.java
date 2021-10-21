package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenerosDuplicadosException extends Exception{

    public GenerosDuplicadosException() {
        super("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
    }
}
