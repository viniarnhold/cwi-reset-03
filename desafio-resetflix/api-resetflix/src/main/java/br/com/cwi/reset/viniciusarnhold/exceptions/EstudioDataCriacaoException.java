package br.com.cwi.reset.viniciusarnhold.exceptions;

public class EstudioDataCriacaoException extends Exception{
    public EstudioDataCriacaoException() {
        super("Não é possível cadastrar estúdios do futuro.");
    }
}
