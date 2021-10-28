package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.domain.PersonagemAtor;
import br.com.cwi.reset.viniciusarnhold.repository.AtorRepository;
import br.com.cwi.reset.viniciusarnhold.repository.PersonagemAtorRepository;
import br.com.cwi.reset.viniciusarnhold.request.AtorRequest;
import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;

    public void criarAtor(AtorRequest atorRequest) throws Exception{

//        -------------------------VALIDAÇÕES DE ATOR FORA DO @VALIDATOR----------------------
        if(atorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException();
        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if(atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new AtorAnoInicioAtividadeException();
        }

        for(Ator atorCadastrado : atorRepository.findAll()){
            if(atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new AtorCadastradoException(atorRequest.getNome());
            }
        }
//        -------------------VALIDAÇÕES DE ATOR FORA DO @VALIDATOR--------------------------------------


        Ator ator = new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());

        atorRepository.save(ator);
    }

    public List<Ator> listarAtoresEmAtividade() throws Exception {

        List<Ator> atoresEmAtividade = atorRepository.findByStatusCarreira(StatusCarreira.EM_ATIVIDADE);

        return atoresEmAtividade;
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();
        List<Ator> atoresEmAtividadeSemFiltro = listarAtoresEmAtividade();

        for(Ator ator : atoresEmAtividadeSemFiltro){
            atoresEmAtividade.add(ator);
        }

        if (atoresEmAtividade.size() == 0) {
            throw new AtorNaoEncontradoNomeException(filtroNome);
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor(Integer id) throws AtorNaoEncontradoIdException {
         Optional<Ator> atorOptional = atorRepository.findById(id);
         if(atorOptional.isPresent()){
             return atorOptional.get();
         } else {
             throw new AtorNaoEncontradoIdException(id);
         }
    }

    public List<Ator> consultarAtores() throws AtorNaoCadastradoException {
        List<Ator> atores = atorRepository.findAll();
        if(atores.size() == 0){
            throw new AtorNaoCadastradoException();
        }
        return atores;
    }

    public void atualizarAtor(@NotNull(message = "Campo obrigatório não informado. Favor informar o campo id.") Integer id,
                              @NotNull(message = "Campo obrigatório não informado. Favor informar o campo atorRequest.")
                              @Valid AtorRequest atorRequest) throws Exception {
        Optional<Ator> atorOptional = atorRepository.findById(id);
        Ator ator = atorOptional.get();
//      ---------------------VALIDAÇÕES FORA DO @VALIDATOR-----------------------------
        Boolean atorExistente = atorRepository.existsByNome(atorRequest.getNome());
        if(atorOptional.isEmpty()){
            throw new Exception("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        if (!ator.getNome().equals(atorRequest.getNome())){
            if (atorExistente){
                throw new Exception("Já existe um ator cadastrado para o nome " + atorRequest.getNome() + ".");
            }
        }
//      ---------------------VALIDAÇÕES FORA DO @VALIDATOR-----------------------------
        ator.setNome(atorRequest.getNome());
        ator.setDataNascimento(atorRequest.getDataNascimento());
        ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());
        ator.setStatusCarreira(atorRequest.getStatusCarreira());
        atorRepository.save(ator);
    }

    public void deletarAtor(@NotNull(message = "Campo obrigatório não informado. Favor informar o campo id.") Integer id) throws Exception {
        Optional<Ator> atorOptional = atorRepository.findById(id);
        Ator ator = atorOptional.get();
        if(atorOptional.isEmpty()){
            throw new Exception("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        for (PersonagemAtor personagemAtor : personagemAtorRepository.findAll()){
            if(personagemAtor.getAtor() == ator){
                throw new Exception("Este ator está vinculado a um ou mais personagens, para remover o ator é necessário remover os seus personagens de atuação.");
            }
        }
        atorRepository.deleteById(id);
    }
}