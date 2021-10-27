package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.repository.AtorRepository;
import br.com.cwi.reset.viniciusarnhold.request.AtorRequest;
import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criarAtor(AtorRequest atorRequest) throws Exception{

        if(atorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException();
        }
//        LocalDate dataAtual = LocalDate.now();
//
//        if(dataAtual.isBefore(atorRequest.getDataNascimento())){
//            throw new AtorDataNascimentoException();
//        }

        Integer anoNascimento = atorRequest.getDataNascimento().getYear();

        if(atorRequest.getAnoInicioAtividade() < anoNascimento){
            throw new AtorAnoInicioAtividadeException();
        }

        for(Ator atorCadastrado : atorRepository.findAll()){
            if(atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())){
                throw new AtorCadastradoException(atorRequest.getNome());
            }
        }

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
}