public class ReposicaoCozinha {

    static void reporItem(String item) {
        //Método adiciona a quantidade do item em questão ao "estoque"

        if ("paes".equals(item)) {
            ItensPorQuantidade.pao += 3600;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.tortaInteira += 4;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche += 20;
        }
    }
}
