package br.com.cwi.reset.viniciusarnhold;

public enum StatusCarreira {
    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    public String descricao;

    StatusCarreira(String descricao) {
        this.descricao = descricao;
    }
}
