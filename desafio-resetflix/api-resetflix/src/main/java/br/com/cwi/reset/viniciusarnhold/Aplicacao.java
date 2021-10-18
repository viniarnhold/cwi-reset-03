package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        //Cadastro primeiro ator
        String nome1 = "Will Smith";
        LocalDate dataNascimento1 = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira1 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade1 = 1986;
        AtorRequest atorRequest1 = new AtorRequest(nome1, dataNascimento1, statusCarreira1, anoInicioAtividade1);

        atorService.criarAtor(atorRequest1);

        //Cadastro segundo ator
        String nome2 = "Jennifer Aniston";
        LocalDate dataNascimento2 = LocalDate.of(1969, Month.FEBRUARY, 11);
        StatusCarreira statusCarreira2 = StatusCarreira.APOSENTADO;
        Integer anoInicioAtividade2 = 1987;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);

        atorService.criarAtor(atorRequest2);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        System.out.println(atores);

        System.out.println("");

        System.out.println(atorService.listarAtoresEmAtividade());
        System.out.println("");

        System.out.println(atorService.listarAtoresEmAtividade("Will Smith"));
        System.out.println("");

        System.out.println(atorService.consultarAtor(2));
        System.out.println("");

        System.out.println(atorService.consultarAtores());
        System.out.println("");
    }
}