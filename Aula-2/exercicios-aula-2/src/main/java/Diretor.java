public class Diretor {
    private String nome;
    private Integer idade;
    private Genero genero;
    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, Integer quantidadeDeFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public String getNome() {
        return nome;
    }

    public void imprimir(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricao());
    }
}
