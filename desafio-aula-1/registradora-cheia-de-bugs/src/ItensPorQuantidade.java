public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
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
}
