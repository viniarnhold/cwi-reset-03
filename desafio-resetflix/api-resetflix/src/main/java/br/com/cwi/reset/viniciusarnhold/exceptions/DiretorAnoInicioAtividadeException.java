package br.com.cwi.reset.viniciusarnhold.exceptions;

public class DiretorAnoInicioAtividadeException extends Exception{

    public DiretorAnoInicioAtividadeException() {
        super("Ano de início de atividade inválido para o diretor cadastrado.");
    }
}
