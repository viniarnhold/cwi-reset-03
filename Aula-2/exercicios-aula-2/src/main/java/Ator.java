public class Ator extends Pessoa{

    private Integer oscarVencido;

    public Ator(String nome, Integer idade, Genero genero, Integer oscarVencido) {
        super(nome, idade, genero);
        this.oscarVencido = oscarVencido;
    }
}
