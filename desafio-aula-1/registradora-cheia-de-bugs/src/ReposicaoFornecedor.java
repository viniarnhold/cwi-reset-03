import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        //Método adiciona a quantidade do item em questão ao "estoque", quando é um dia útil
        Random random = new Random();

        if ("leite".equals(item)) {
            ItensPorQuantidade.leite += random.nextInt(40) + 10;
        }

        if ("cafe".equals(item)) {
            ItensPorQuantidade.cafe += random.nextInt(40) + 10;
        }
    }
}
