public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {

        //Método calcula o preço do item em questão, com base no item e quantidade informados

        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = qtd * (12.75 * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = (96.00/16) * qtd;
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
