package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;
import br.com.cwi.reset.viniciusarnhold.request.AtorRequest;
import br.com.cwi.reset.viniciusarnhold.request.DiretorRequest;
import br.com.cwi.reset.viniciusarnhold.services.AtorService;
import br.com.cwi.reset.viniciusarnhold.services.DiretorService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

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

        DiretorRequest diretorRequest1 = new DiretorRequest("Quentin Tarantino", LocalDate.of(1963,03,27), 1987);
        DiretorRequest diretorRequest2 = new DiretorRequest("Steven Spielberg", LocalDate.of(1946,12,18), 1971);



        diretorService.cadastrarDiretor(diretorRequest1);
        diretorService.cadastrarDiretor(diretorRequest2);

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println(diretores);

        System.out.println(diretorService.listarDiretores("Quentin Tarantino"));
    }
}