package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Ator cadastrarAtor(Ator ator){
        return (Ator) atorRepository.save(ator);
    }

    public Ator consultarAtor(String nome){
        return atorRepository.findByNome(nome);
    }

    public Ator consultarAtor(Integer quantidadeOscars){
        return atorRepository.findByNumeroOscar(quantidadeOscars);
    }


    public List<Ator> consultarAtoresPorOscar(Integer quantidadeOscar){
        List<Ator> atoresComOscarMaior = null;
        List<Ator> atores = (List<Ator>) atorRepository.findAll();

        for(Ator ator : atores){
            if (ator.getNumeroOscars() > quantidadeOscar){
                atoresComOscarMaior.add(ator);
            }
        }
        return atoresComOscarMaior;
    }

    public void deletarAtor(Integer id){
        atorRepository.deleteById(id);
    }

    public Ator consultarAtorPorAnoNascimento(Integer anoNascimento){
        return atorRepository.findByAnoNascimento(anoNascimento);
    }

}
