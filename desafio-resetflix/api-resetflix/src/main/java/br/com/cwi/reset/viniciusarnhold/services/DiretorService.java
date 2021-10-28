package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.domain.Filme;
import br.com.cwi.reset.viniciusarnhold.repository.DiretorRepository;
import br.com.cwi.reset.viniciusarnhold.repository.FilmeRepository;
import br.com.cwi.reset.viniciusarnhold.request.DiretorRequest;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

//        -------------------------VALIDAÇÕES DE DIRETOR FORA DO @VALIDATOR----------------------
        if(diretorRequest.getNome().split(" ").length < 2){
            throw new NomeESobrenomeException();
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
//        -------------------------VALIDAÇÕES DE DIRETOR FORA DO @VALIDATOR----------------------

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

    public void atualizarDiretor(@NotNull(message = "Campo obrigatório não informado. Favor informar o campo id") Integer id,
                                 @NotNull(message = "Campo obrigatório não informado. Favor informar o campo diretorRequest")
                                 @Valid DiretorRequest diretorRequest) throws Exception {
        Optional<Diretor> diretorOptional = diretorRepository.findById(id);
        Diretor diretor = diretorOptional.get();
//      ---------------------VALIDAÇÕES FORA DO @VALIDATOR-----------------------------
        Boolean diretorExistente = diretorRepository.existsByNome(diretorRequest.getNome());
        if (diretorOptional.isEmpty()){
            throw new Exception("Nenhum diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        if (!diretor.getNome().equals(diretorRequest.getNome())){
            if(diretorExistente){
                throw new Exception("Já existe um diretor cadastrado para o nome" + diretorRequest.getNome() + ".");
            }
        }
//      ---------------------VALIDAÇÕES FORA DO @VALIDATOR-----------------------------
        diretor.setNome(diretorRequest.getNome());
        diretor.setDataNascimento(diretorRequest.getDataNascimento());
        diretor.setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());
        diretorRepository.save(diretor);
    }

    public void removerDiretores(@NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome") Integer id) throws Exception {
        Optional<Diretor> diretorOptional = diretorRepository.findById(id);
        if (diretorOptional.isEmpty()){
            throw new Exception("Nenhum diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
        }
        Diretor diretor = diretorOptional.get();
        for(Filme filme : filmeRepository.findAll()) {
            if (filme.getDiretor() == diretor) {
                throw new Exception("Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação.");
            }
        }
        diretorRepository.deleteById(id);
    }
}
