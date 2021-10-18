package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtorNaoEncontradoNomeException extends Exception{

    public AtorNaoEncontradoNomeException(String filtroNome) {
        super("Ator não encontrado com filtro " + filtroNome + ", favor informar outro nome");
    }
}
