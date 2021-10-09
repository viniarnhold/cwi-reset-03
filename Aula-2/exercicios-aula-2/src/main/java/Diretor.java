public class Diretor extends Pessoa{
    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, Integer quantidadeDeFilmesDirigidos) {
        super(nome, idade, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

}
