package br.com.cwi.reset.viniciusarnhold.exceptions;

public class CampoObrigatorioException extends Exception{

    public CampoObrigatorioException(String campo) {
        super("Campo obrigatório não informado. Favor informar o campo " + campo);
    }
}
