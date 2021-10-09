public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("Guel Arraes", 67,Genero.MASCULINO ,11);
        Filme filme1 = new Filme("O auto da compadecida", "As aventuras de João Grilo e Chicó, " +
                "dois nordestinos pobres que vivem de golpes para sobreviver", 157,
                2000, 4.7f, diretor);

        Filme filme2 = new Filme("60 segundos", "Randall Memphis Raines é um ex-ladrão de carros " +
                "que se vê forçado a roubar 50 veículos de luxo em uma noite para salvar a vida de seu irmão, " +
                "que caiu em desgraça com um perigoso senhor do crime.", 117, 2000,
                4.1f, "Dominic Sena", 72, Genero.MASCULINO, 13);

        filme1.reproduzir();
        System.out.println("");
        diretor.imprimir();
        System.out.println("");
        filme2.reproduzir();

    }
}
