package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.domain.*;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import br.com.cwi.reset.viniciusarnhold.repository.FilmeRepository;
import br.com.cwi.reset.viniciusarnhold.repository.PersonagemAtorRepository;
import br.com.cwi.reset.viniciusarnhold.request.FilmeRequest;
import br.com.cwi.reset.viniciusarnhold.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorService diretorService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private AtorService atorService;
    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;

//    public Diretor consultarDiretorId(Integer idDiretor) throws Exception{
//        Optional<Diretor> diretorOptional =
//        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
//            if (diretor.getId() == idDiretor) {
//                diretorConsultado = diretor;
//                break;
//            }
//        }
//        if(diretorConsultado == null) {
//            throw new DiretorNaoEncontradoIdException(idDiretor);
//        }
//        return diretorConsultado;
//    }

//    public Estudio consultarEstudioId(Integer idEstudio) throws Exception{
//        Estudio estudioConsultado = null;
//        for (Estudio estudio : fakeDatabase.recuperaEstudios()) {
//            if (estudio.getId() == idEstudio) {
//                estudioConsultado = estudio;
//                break;
//            }
//        }
//        if(estudioConsultado == null) {
//            throw new EstudioNaoEncontradoIdException(idEstudio);
//        }
//        return estudioConsultado;
//    }

//    public Ator consultarAtorId(Integer idAtor) throws Exception{
//        Ator atorConsultado = null;
//        for (Ator ator : fakeDatabase.recuperaAtores()) {
//            if (ator.getId() == idAtor) {
//                atorConsultado = ator;
//                break;
//            }
//        }
//        if(atorConsultado == null) {
//            throw new AtorNaoEncontradoIdException(idAtor);
//        }
//        return atorConsultado;
//    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        if(filmeRequest.getNome() == null) { throw new CampoObrigatorioNomeException(); }
        if(filmeRequest.getAnoLancamento() == null){ throw new CampoObrigatorioException("anoLancamento"); }
        if(filmeRequest.getCapaFilme() == null){ throw new CampoObrigatorioException("capaFilme"); }
        if(filmeRequest.getGeneros() == null) { throw new CampoObrigatorioException("generos"); }
        if(filmeRequest.getIdDiretor() == null){ throw new CampoObrigatorioException("idDiretor"); }
        if(filmeRequest.getIdEstudio() == null) { throw new CampoObrigatorioException("idEstudio"); }
        if(filmeRequest.getResumo() == null){ throw new CampoObrigatorioException("resumo"); }
        if(filmeRequest.getPersonagens() == null) { throw new CampoObrigatorioException("personagens"); }

        Estudio estudioDoFilme = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
        Diretor diretorDoFilme = diretorService.consultarDiretor(filmeRequest.getIdDiretor());


        List<PersonagemAtor> personagens = new ArrayList<>();
        for(PersonagemRequest personagem : filmeRequest.getPersonagens()){
            if(personagem.getDescricaoPersonagem() == null) {
                throw new CampoObrigatorioException("descricao");
            }
            if(personagem.getNomePersonagem() == null){
                throw new CampoObrigatorioException("nomePersonagem");
            }
            if(personagem.getIdAtor() == null){
                throw new CampoObrigatorioException("idAtor");
            }
            if(personagem.getTipoAtuacao() == null){
                throw new CampoObrigatorioException("tipoAtuacao");
            }

            PersonagemAtor personagemAtor = new PersonagemAtor(atorService.consultarAtor(personagem.getIdAtor()), personagem.getNomePersonagem(),
                    personagem.getDescricaoPersonagem(), personagem.getTipoAtuacao());
            personagemAtorRepository.save(personagemAtor);
            personagens.add(personagemAtor);
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

        for(int i = 0; i < filmeRequest.getPersonagens().size(); i++){
            for(int j = i + 1 ; j < filmeRequest.getPersonagens().size(); j++){
                if (personagens.get(i).getId() == personagens.get(j).getId() && personagens.get(i).getNomePersonagem().equals(personagens.get(j).getNomePersonagem())){
                    throw new FilmeAtorEPersonagemRepetidoException();
                }
            }
        }

        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(),
                estudioDoFilme, diretorDoFilme, personagens, filmeRequest.getResumo());

        filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {
        List<Filme> filmesConsultados = new ArrayList<>();
        if(nomeFilme != null) {
            for (Filme filme : filmeRepository.findAll()) {
                if (filme.getNome().equals(nomeFilme)) {
                    filmesConsultados.add(filme);
                }
            }
        }
        if(nomeDiretor != null) {
            Diretor diretor = diretorService.consultarDiretor(nomeDiretor);
            for (Filme filme : filmeRepository.findAll()) {
                if (diretor.getNome().equals(nomeDiretor)) {
                    filmesConsultados.add(filme);
                }
            }
        }
        if(nomePersonagem != null) {
            for (Filme filme : filmeRepository.findAll()) {
                for (PersonagemAtor personagem : filme.getPersonagens()) {
                    if (personagem.getNomePersonagem().equals(nomePersonagem)) {
                        filmesConsultados.add(filme);
                    }
                }
            }
        }
        if(nomeAtor != null){
            for(Filme filme : filmeRepository.findAll()) {
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