public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("Guel Arraes", 18-02-1963,Genero.MASCULINO ,11);
        Filme filme1 = new Filme("O auto da compadecida", "As aventuras de João Grilo e Chicó, " +
                "dois nordestinos pobres que vivem de golpes para sobreviver", 157,
                2000, 0.7f, diretor);

        filme1.reproduzir();
        System.out.println("");
        diretor.imprimir();
        System.out.println("");
        filme2.reproduzir();

    }
}
