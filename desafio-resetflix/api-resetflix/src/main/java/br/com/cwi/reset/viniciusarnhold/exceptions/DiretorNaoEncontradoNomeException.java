package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorNaoEncontradoNomeException extends Exception{

    public DiretorNaoEncontradoNomeException(String filtroNome) {
        super("Diretor não encontrado com filtro " + filtroNome + ", favor informar outro nome");
    }
}
