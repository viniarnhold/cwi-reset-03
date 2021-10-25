package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.repository.DiretorRepository;
import br.com.cwi.reset.viniciusarnhold.request.DiretorRequest;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

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

        for(Diretor diretorCadastrado : diretorRepository.findAll()){
            if(diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())){
                throw new DiretorCadastradoException(diretorCadastrado.getNome());
            }
        }

        Diretor diretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());

        diretorRepository.save(diretor);
    }

        public List listarDiretores() throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : diretorRepository.findAll()){
                diretores.add(diretor);

                if(diretores.size() == 0){
                    throw new DiretorNaoCadastradoException();
                }
            }
            return diretores;
        }
        public List listarDiretores(String filtroNome) throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : diretorRepository.findAll()){
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
        Optional<Diretor> diretorOptional = diretorRepository.findById(id);
        if (diretorOptional.isPresent()) {
            return diretorOptional.get();
        } else {
            throw new DiretorNaoEncontradoIdException(id);
        }
    }

    public Diretor consultarDiretor(String nome) throws Exception{
        Optional<Diretor> diretorOptional = diretorRepository.findByNome(nome);
        if (diretorOptional.isPresent()) {
            return diretorOptional.get();
        } else {
            throw new DiretorNaoEncontradoNomeException(nome);
        }
    }

    // Demais métodos da classe
}
