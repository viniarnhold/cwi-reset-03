package br.com.cwi.reset.viniciusarnhold.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoObrigatorioDataNascimento extends CampoObrigatorioException{

    public CampoObrigatorioDataNascimento() {
        super("dataNascimento");
    }
}
