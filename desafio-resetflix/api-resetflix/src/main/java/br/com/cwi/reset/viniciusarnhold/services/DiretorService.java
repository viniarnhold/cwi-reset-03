package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.request.DiretorRequest;
import br.com.cwi.reset.viniciusarnhold.FakeDatabase;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        if (diretorRequest.getNome() == null) { throw new CampoObrigatorioNomeException(); }
        if (diretorRequest.getDataNascimento() ==null) { throw new CampoObrigatorioDataNascimento(); }
        if (diretorRequest.getAnoInicioAtividade() == null) { throw new CampoObrigatorioAnoInicioAtividadeException(); }

        if(diretorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException();
        }
        LocalDate dataAtual = LocalDate.now();

        if(dataAtual.isBefore(diretorRequest.getDataNascimento())){
            throw new DiretorDataNascimentoException();
        }

        Integer anoNascimento = diretorRequest.getDataNascimento().getYear();

        if(diretorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new DiretorAnoInicioAtividadeException();
        }

        for(Diretor diretorCadastrado : fakeDatabase.recuperaDiretores()){
            if(diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())){
                throw new DiretorCadastradoException(diretorCadastrado.getNome());
            }
        }

        Diretor diretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        fakeDatabase.persisteDiretor(diretor);
    }

        public List listarDiretores() throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : fakeDatabase.recuperaDiretores()){
                diretores.add(diretor);

                if(diretores.size() == 0){
                    throw new DiretorNaoCadastradoException();
                }
            }
            return diretores;
        }
        public List listarDiretores(String filtroNome) throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : fakeDatabase.recuperaDiretores()){
                if(diretor.getNome().equals(filtroNome)) {
                        diretores.add(diretor);
                    if (diretores.size() == 0) {
                        throw new DiretorNaoEncontradoNomeException(filtroNome);
                    }
                }
            }
            return diretores;
        }

    public Diretor consultarDiretor(Integer id) throws Exception{
        Diretor diretorConsultado = null;
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (diretor.getId() == id) {
                diretorConsultado = diretor;
            }
        }
        if(diretorConsultado == null) {
            throw new DiretorNaoEncontradoIdException(id);
        }
        return diretorConsultado;
    }

    public Diretor consultarDiretor(String nome) throws Exception{
        Diretor diretorConsultado = null;
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (diretor.getNome().equals(nome)) {
                diretorConsultado = diretor;
            }
        }
        if(diretorConsultado == null) {
            throw new DiretorNaoEncontradoNomeException(nome);
        }
        return diretorConsultado;
    }

    // Demais métodos da classe
}
