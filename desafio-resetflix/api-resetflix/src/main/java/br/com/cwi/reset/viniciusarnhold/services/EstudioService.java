package br.com.cwi.reset.viniciusarnhold.services;

import br.com.cwi.reset.viniciusarnhold.FakeDatabase;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.domain.Estudio;
import br.com.cwi.reset.viniciusarnhold.enums.StatusAtividade;
import br.com.cwi.reset.viniciusarnhold.exceptions.*;
import br.com.cwi.reset.viniciusarnhold.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null){ throw new CampoObrigatorioNomeException(); }
        if (estudioRequest.getDescricao() == null){ throw new CampoObrigatorioDescricaoException(); }
        if (estudioRequest.getDataCriacao() == null){ throw new CampoObrigatorioDataCriacaoException(); }
        if (estudioRequest.getStatusAtividade() == null){ throw new CampoObrigatorioStatusAtividade(); }

        for(Estudio estudio : fakeDatabase.recuperaEstudios()){
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

        fakeDatabase.persisteEstudio(estudio);

    }

    public List listarEstudio() throws Exception {

            List<Estudio> estudios = fakeDatabase.recuperaEstudios();

            if(estudios.size() == 0){
                throw new EstudioNaoCadastradoException();
            }
        return estudios;
    }

    public List listarEstudio(String filtroNome) throws Exception {
        List<Estudio> estudios = new ArrayList<>();

        for(Estudio estudio : fakeDatabase.recuperaEstudios()){
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
        Estudio estudioEncontrado = null;
        for(Estudio estudio : fakeDatabase.recuperaEstudios()){
            if (estudio.getId() == id){
                estudioEncontrado = estudio;
            } else {
                throw new EstudioNaoEncontradoIdException(id);
            }
        }
        return estudioEncontrado;
    }

}
