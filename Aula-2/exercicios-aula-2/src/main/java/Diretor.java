public class Diretor {
    private String nome;
    private Integer idade;
    private Integer quantidadeDeFilmesDirigidos;

    public Diretor(String nome, Integer idade, Integer quantidadeDeFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getQuantidadeDeFilmesDirigidos() {
        return quantidadeDeFilmesDirigidos;
    }

    public void setQuantidadeDeFilmesDirigidos(Integer quantidadeDeFilmesDirigidos) {
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }
}
