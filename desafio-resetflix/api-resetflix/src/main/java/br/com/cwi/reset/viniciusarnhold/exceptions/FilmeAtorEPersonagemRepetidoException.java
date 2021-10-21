package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FilmeAtorEPersonagemRepetidoException extends Exception{

    public FilmeAtorEPersonagemRepetidoException() {
        super("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
    }
}
