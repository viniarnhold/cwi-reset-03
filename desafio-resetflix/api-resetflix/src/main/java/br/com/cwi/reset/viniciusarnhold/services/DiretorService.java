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
        Diretor diretor = new Diretor();
        if (!diretorRequest.getNome().equals(null)) {
            diretor.setNome(diretorRequest.getNome());
        } else {
            throw new CampoObrigatorioNomeException();
        }

        if (!diretorRequest.getDataNascimento().equals(null)) {
            diretor.setDataNascimento(diretorRequest.getDataNascimento());
        } else {
            throw new CampoObrigatorioDataNascimento();
        }

        if (!diretorRequest.getAnoInicioAtividade().equals(null)) {
            diretor.setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());
        } else {
            throw new CampoObrigatorioAnoInicioAtividadeException();
        }

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

    // Demais métodos da classe
}
