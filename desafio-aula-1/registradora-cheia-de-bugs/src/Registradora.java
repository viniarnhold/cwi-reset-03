
public class Registradora {

    public static void main(String[] args) {
//        primeiroBug();

//       segundoBug();

        terceiroBug();

//        quartoBug();

//        quintoBug();

//        sextoBug();

    }

    private static void reposicaoItens(String item){
        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Reposição de " + item + " não disponível");
                    ItensPorQuantidade.informarQuantidadeRestante(item);

                } else {
                    ReposicaoCozinha.reporItem(item);
                }
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = 0;
        reposicaoItens(item);

        if ("pao".equals(item)) {
            if (ItensPorQuantidade.pao >= quantidade) {
                ItensPorQuantidade.diminuirQuantidade(item, quantidade);
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            } else {
                System.out.println("Não há estoque suficiente para a venda");
                precoItem = 0.00;
            }
        }
        if ("sanduiche".equals(item)) {
            if (ItensPorQuantidade.sanduiche >= quantidade) {
                ItensPorQuantidade.diminuirQuantidade(item, quantidade);
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            } else {
                System.out.println("Não há estoque suficiente para a venda");
                precoItem = 0.00;
            }
        }
        if ("torta".equals(item)) {
            if (ItensPorQuantidade.torta >= quantidade) {
                ItensPorQuantidade.diminuirQuantidade(item, quantidade);
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            } else {
                System.out.println("Não há estoque suficiente para a venda");
                precoItem = 0.00;
            }
        }
        if ("leite".equals(item)) {
            if (ItensPorQuantidade.leite >= quantidade) {
                ItensPorQuantidade.diminuirQuantidade(item, quantidade);
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            } else {
                System.out.println("Não há estoque suficiente para a venda");
                precoItem = 0.00;
            }
        }
        if ("cafe".equals(item)) {
            if (ItensPorQuantidade.cafe >= quantidade) {
                ItensPorQuantidade.diminuirQuantidade(item, quantidade);
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            } else {
                System.out.println("Não há estoque suficiente para a venda");
                precoItem = 0.00;
            }
        }

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
