public class ItensPorQuantidade {

    static int pao = 3600;
    static int tortaInteira = 4;
    static int torta = tortaInteira * 16;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static void informarQuantidadeRestante(String item){
        if ("pao".equals(item)) {
            System.out.println("Quantidade restante de " + item + " é " + pao);
        } else if ("torta".equals(item)) {
            System.out.println("Quantidade restante de " + item + " é " + torta);
        } else if ("sanduiche".equals(item)) {
            System.out.println("Quantidade restante de " + item + " é " + sanduiche);
        } else if ("leite".equals(item)) {
            System.out.println("Quantidade restante de " + item + " é " + leite);
        } else if ("cafe".equals(item)) {
            System.out.println("Quantidade restante de " + item + " é " + cafe);
        } else {
            System.out.println("Produto não encontrado");
        }
    }
    public static void diminuirQuantidade(String item, int quantidade){
        if ("pao".equals(item)) {
                pao -= quantidade;
        }
        if ("torta".equals(item)) {
            torta -= quantidade;
            tortaInteira = (int)torta/16;
        }
        if ("sanduiche".equals(item)) {
                sanduiche -= quantidade;
        }
        if ("leite".equals(item)) {
            leite -= quantidade;
        }
        if ("cafe".equals(item)) {
            cafe -= quantidade;
        }

    }
}
