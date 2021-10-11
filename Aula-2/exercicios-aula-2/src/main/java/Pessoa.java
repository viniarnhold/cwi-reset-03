import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void imprimir(){
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Genero: " + genero.getDescricao());
    }

    public void calcularIdade(){
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(hoje, this.dataNascimento);
        System.out.println("Idade: " + idade);
    }

    public String getNome() {
        return nome;
    }
}
