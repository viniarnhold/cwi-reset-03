package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AtorAnoInicioAtividadeException extends Exception{

    public AtorAnoInicioAtividadeException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
