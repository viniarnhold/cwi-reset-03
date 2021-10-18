package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorAnoInicioAtividadeException extends Exception{

    public DiretorAnoInicioAtividadeException() {
        super("Ano de início de atividade inválido para o diretor cadastrado.");
    }
}
