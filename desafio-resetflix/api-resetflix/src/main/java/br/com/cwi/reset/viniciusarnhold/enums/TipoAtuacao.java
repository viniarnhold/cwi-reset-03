package br.com.cwi.reset.viniciusarnhold.enums;

public enum TipoAtuacao {
    PRINCIPAL("principal"),
    COADJUVANTE("Coadjuvante");

    private String descricao;

    TipoAtuacao(String descricao) {
        this.descricao = descricao;
    }
}
