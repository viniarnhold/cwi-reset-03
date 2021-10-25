package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.domain.Estudio;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import br.com.cwi.reset.viniciusarnhold.repository.EstudioRepository;
import br.com.cwi.reset.viniciusarnhold.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null){ throw new CampoObrigatorioNomeException(); }
        if (estudioRequest.getDescricao() == null){ throw new CampoObrigatorioDescricaoException(); }
        if (estudioRequest.getDataCriacao() == null){ throw new CampoObrigatorioDataCriacaoException(); }
        if (estudioRequest.getStatusAtividade() == null){ throw new CampoObrigatorioStatusAtividade(); }

        for(Estudio estudio : estudioRepository.findAll()){
            if(estudioRequest.getNome().equals(estudio.getNome())){
                throw new EstudioEncontradoException(estudioRequest.getNome());
            }
        }

        LocalDate dataAtual = LocalDate.now();
        if (estudioRequest.getDataCriacao().isAfter(dataAtual)){
            throw new EstudioDataCriacaoException();
        }

        Estudio estudio = new Estudio(estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade());

        estudioRepository.save(estudio);

    }

    public List<Estudio> listarEstudio() throws Exception {
        List<Estudio> estudios = estudioRepository.findAll();

        if(estudios.size() == 0){
            throw new EstudioNaoCadastradoException();
        }
        return estudios;
    }

    public List<Estudio> listarEstudio(String filtroNome) throws Exception {
        List<Estudio> estudios = new ArrayList<>();

        for(Estudio estudio : estudioRepository.findAll()){
            if(estudio.getNome().equals(filtroNome)) {
                estudios.add(estudio);
                if (estudios.size() == 0) {
                    throw new EstudioNaoCadastradoException(filtroNome);
                }
            }
        }
        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        Optional<Estudio> estudioOptional = estudioRepository.findById(id);
        if (estudioOptional.isPresent()){
            return estudioOptional.get();
        } else {
            throw new EstudioNaoEncontradoIdException(id);
        }
    }

}
