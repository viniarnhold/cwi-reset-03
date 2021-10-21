package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstudioNaoCadastradoException extends Exception{

    public EstudioNaoCadastradoException() {
        super("Nenhum estúdio cadastrado, favor cadastar estúdios.");
    }

    public EstudioNaoCadastradoException(String filtroNome) {
        super("Estúdio não encontrato com o filtro " + filtroNome + " favor informar outro filtro.");
    }
}
