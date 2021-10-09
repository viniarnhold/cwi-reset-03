public class Filme {
    private String nome;
    private String descrição;
    private Integer duracao;
    private Integer anoDeLancamento;
    private Float avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descrição, Integer duracao,
                 Integer anoDeLancamento, Float avaliacao, String nomeDiretor,
                 Integer idadeDoDiretor, Genero generoDiretor, Integer quantidadesDeFilmesDoDiretor) {
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.diretor = new Diretor(nomeDiretor, idadeDoDiretor, generoDiretor, quantidadesDeFilmesDoDiretor);
    }
    public Filme(String nome, String descrição, Integer duracao,
                 Integer anoDeLancamento, Float avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descrição: " + this.descrição);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Diretor: " + diretor.getNome());

    }}
