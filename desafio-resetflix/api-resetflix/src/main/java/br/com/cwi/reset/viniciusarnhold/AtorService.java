package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception{
        Ator ator = new Ator();
        if(!atorRequest.getNome().equals(null)) {
            ator.setNome(atorRequest.getNome());
        } else {
            throw new CampoObrigatorioNomeException();
        }

        if(!atorRequest.getDataNascimento().equals(null)){
            ator.setDataNascimento(atorRequest.getDataNascimento());
        } else {
            throw new CampoObrigatorioDataNascimento();
        }

        if(!atorRequest.getStatusCarreira().equals(null)){
            ator.setStatusCarreira(atorRequest.getStatusCarreira());
        } else {
            throw new CampoObrigatorioStatusCarreira();
        }

        if(!atorRequest.getAnoInicioAtividade().equals(null)) {
            ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());
        } else{
            throw new CampoObrigatorioAnoInicioAtividadeException();
        }

        if(atorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException();
        }
        LocalDate dataAtual = LocalDate.now();

        if(dataAtual.isBefore(atorRequest.getDataNascimento())){
            throw new AtorDataNascimentoException();
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if(atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new AtorAnoInicioAtividadeException();
        }

        for(Ator atorCadastrado : fakeDatabase.recuperaAtores()){
            if(atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new AtorCadastradoException(atorRequest.getNome());
            }
        }


        fakeDatabase.persisteAtor(ator);
    }

    public List listarAtoresEmAtividade() throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for(Ator ator : fakeDatabase.recuperaAtores()){

            if(ator.getStatusCarreira() == StatusCarreira.EM_ATIVIDADE){
                atoresEmAtividade.add(ator);
            }
            if(atoresEmAtividade.size() == 0){
                throw new AtorNaoCadastradoException();
            }
        }
        return atoresEmAtividade;
    }
    public List listarAtoresEmAtividade(String filtroNome) throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for(Ator ator : fakeDatabase.recuperaAtores()){
            if(ator.getNome().equals(filtroNome)) {
                if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                    atoresEmAtividade.add(ator);
                }
                if (atoresEmAtividade.size() == 0) {
                    throw new AtorNaoEncontradoNomeException(filtroNome);
                }
            }
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor(Integer id) throws Exception{
        Ator atorConsultado = null;
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getId() == id) {
                atorConsultado = ator;
            }
        }
        if(atorConsultado == null) {
            throw new AtorNaoEncontradoIdException(id);
        }
        return atorConsultado;
    }

    public List consultarAtores() throws Exception{
        List<Ator> atores = new ArrayList<>();

            for(Ator ator : fakeDatabase.recuperaAtores()){
                atores.add(ator);
            }
            if(atores.size() == 0){
                throw new AtorNaoCadastradoException();
            }
        return atores;
    }




    // Demais métodos da classe
}