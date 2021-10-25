package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.FakeDatabase;
import br.com.cwi.reset.viniciusarnhold.domain.*;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import br.com.cwi.reset.viniciusarnhold.request.FilmeRequest;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private AtorService atorService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public Diretor consultarDiretorId(Integer idDiretor) throws Exception{
        Diretor diretorConsultado = null;
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (diretor.getId() == idDiretor) {
                diretorConsultado = diretor;
                break;
            }
        }
        if(diretorConsultado == null) {
            throw new DiretorNaoEncontradoIdException(idDiretor);
        }
        return diretorConsultado;
    }

    public Estudio consultarEstudioId(Integer idEstudio) throws Exception{
        Estudio estudioConsultado = null;
        for (Estudio estudio : fakeDatabase.recuperaEstudios()) {
            if (estudio.getId() == idEstudio) {
                estudioConsultado = estudio;
                break;
            }
        }
        if(estudioConsultado == null) {
            throw new EstudioNaoEncontradoIdException(idEstudio);
        }
        return estudioConsultado;
    }

    public Ator consultarAtorId(Integer idAtor) throws Exception{
        Ator atorConsultado = null;
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getId() == idAtor) {
                atorConsultado = ator;
                break;
            }
        }
        if(atorConsultado == null) {
            throw new AtorNaoEncontradoIdException(idAtor);
        }
        return atorConsultado;
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        if(filmeRequest.getNome() == null) { throw new CampoObrigatorioNomeException(); }
        if(filmeRequest.getAnoLancamento() == null){ throw new CampoObrigatorioException("anoLancamento"); }
        if(filmeRequest.getCapaFilme() == null){ throw new CampoObrigatorioException("capaFilme"); }
        if(filmeRequest.getGeneros() == null) { throw new CampoObrigatorioException("generos"); }
        if(filmeRequest.getIdDiretor() == null){ throw new CampoObrigatorioException("idDiretor"); }
        if(filmeRequest.getIdEstudio() == null) { throw new CampoObrigatorioException("idEstudio"); }
        if(filmeRequest.getResumo() == null){ throw new CampoObrigatorioException("resumo"); }
        if(filmeRequest.getPersonagens() == null) { throw new CampoObrigatorioException("personagens"); }

        //Estudio estudioDoFilme = consultarEstudioId(filmeRequest.getIdEstudio());
        //Diretor diretorDoFilme = consultarDiretorId(filmeRequest.getIdDiretor());

        for(PersonagemAtor personagem : filmeRequest.getPersonagens()){
            consultarAtorId(personagem.getId());
        }
        if(filmeRequest.getGeneros().size() == 0){
            throw new GeneroVazioException();
        }
        for(int i = 0; i < filmeRequest.getGeneros().size(); i++){
            for(int j = i + 1 ; j < filmeRequest.getGeneros().size(); j++) {
                if (filmeRequest.getGeneros().get(i) == (filmeRequest.getGeneros().get(j))) {
                    throw new GenerosDuplicadosException();
                }
            }
        }
        List<PersonagemAtor> personagens = filmeRequest.getPersonagens();
        for(int i = 0; i < filmeRequest.getPersonagens().size(); i++){
            for(int j = i + 1 ; j < filmeRequest.getPersonagens().size(); j++){
                if (personagens.get(i).getId() == personagens.get(j).getId() && personagens.get(i).getNomePersonagem().equals(personagens.get(j).getNomePersonagem())){
                    throw new FilmeAtorEPersonagemRepetidoException();
                }
            }
        }

        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(),
                filmeRequest.getIdEstudio(), filmeRequest.getIdDiretor(), filmeRequest.getPersonagens(), filmeRequest.getResumo());

        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {
        List<Filme> filmesConsultados = new ArrayList<>();
        if(nomeFilme != null) {
            for (Filme filme : fakeDatabase.recuperaFilmes()) {
                if (filme.getNome().equals(nomeFilme)) {
                    filmesConsultados.add(filme);
                }
            }
        }
//        if(nomeDiretor != null) { ========================================================================
//            Diretor diretor = diretorService.consultarDiretor(nomeDiretor);
//            for (Filme filme : fakeDatabase.recuperaFilmes()) {
//                if (diretor.getId() == filme.getAnoLancamento()) {
//                    filmesConsultados.add(filme);
//                } PRECISA ARRUMAR ISSO AQUI---------------------------------------------------------------
//            }
//        }
        if(nomePersonagem != null) {
            for (Filme filme : fakeDatabase.recuperaFilmes()) {
                for (PersonagemAtor personagem : filme.getPersonagens()) {
                    if (personagem.getNomePersonagem().equals(nomePersonagem)) {
                        filmesConsultados.add(filme);
                    }
                }
            }
        }
        if(nomeAtor != null){
            for(Filme filme : fakeDatabase.recuperaFilmes()) {
                for (PersonagemAtor personagem : filme.getPersonagens()) {
                    if (personagem.getAtor().equals(nomeAtor)) {
                        filmesConsultados.add(filme);
                    }
                }
            }
        }
        if(filmesConsultados.size() == 0){
            throw new Exception("Não existe filme cadastrado para nenhum desses parâmetros");
        }
        return filmesConsultados;
    }
}
