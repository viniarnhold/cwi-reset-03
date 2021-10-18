package br.com.cwi.reset.viniciusarnhold.exceptions;

public class AnoInicioAtividadeException extends Exception{

    public AnoInicioAtividadeException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
