public class Ator {
    private String nome;
    private Integer idade;
    private Integer oscarVencido;
    private Genero genero;

    public void imprimirNome(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricao());
    }
}
