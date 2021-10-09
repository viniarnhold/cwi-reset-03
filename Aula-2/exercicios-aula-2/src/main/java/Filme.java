public class Filme {
    private String nome;
    private String descrição;
    private Integer duracao;
    private Integer anoDeLancamento;
    private Float avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descrição, Integer duracao,
                 Integer anoDeLancamento, Float avaliacao, String nomeDiretor,
                 Integer idadeDoDiretor, Integer quantidadesDeFilmesDoDiretor) {
        this.nome = nome;
        this.descrição = descrição;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        this.avaliacao = avaliacao;
        this.diretor = new Diretor(nomeDiretor, idadeDoDiretor, quantidadesDeFilmesDoDiretor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public Float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descrição: " + this.descrição);
        System.out.println("Duração: " + this.duracao + " minutos");
        System.out.println("Diretor: " + diretor.getNome());

    }}
