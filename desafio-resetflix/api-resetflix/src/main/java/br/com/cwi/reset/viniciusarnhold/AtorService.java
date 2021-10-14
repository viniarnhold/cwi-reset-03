package br.com.cwi.reset.viniciusarnhold;

import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;

import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception{
        Ator ator = new Ator();
        if(!atorRequest.getNome().equals(null)) {
            ator.setNome(atorRequest.getNome());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo nome");
        }

        if(!atorRequest.getDataNascimento().equals(null)){
            ator.setDataNascimento(atorRequest.getDataNascimento());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo dataNascimento");
        }

        if(!atorRequest.getStatusCarreira().equals(null)){
            ator.setStatusCarreira(atorRequest.getStatusCarreira());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo statusCarreira");
        }

        if(!atorRequest.getAnoInicioAtividade().equals(null)) {
            ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());
        } else{
            throw new Exception("Campo obrigatório não informado. Favor informar o campo anoInicioAtividade");
        }

        fakeDatabase.persisteAtor(ator);
    }

    public List listarAtoresEmAtividade() throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for(Ator ator : fakeDatabase.recuperaAtores()){

            if(ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)){
                atoresEmAtividade.add(ator);
            }
            if(atoresEmAtividade.size() == 0){
                throw new Exception("Nenhum ator cadastrado, favor cadastar atores.");
            }
        }
        return atoresEmAtividade;
    }
    public List listarAtoresEmAtividade(String filtroNome) throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();

        for(Ator ator : fakeDatabase.recuperaAtores()){
            if(ator.getNome().equals(filtroNome)) {
                if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                    atoresEmAtividade.add(ator);
                }
                if (atoresEmAtividade.size() == 0) {
                    throw new Exception("Ator não encontrado com filtro " + filtroNome + ", favor informar outro nome");
                }
            }
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor(Integer id) throws Exception{
        Ator atorConsultado = null;
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getId() == id) {
                atorConsultado = ator;
            }
        }
        if(atorConsultado == null) {
            throw new Exception("Nenhum ator encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
        }
        return atorConsultado;
    }

    public List consultarAtores() throws Exception{
        List<Ator> atores = new ArrayList<>();

        try {
            for(Ator ator : fakeDatabase.recuperaAtores()){
                atores.add(ator);
            }
            if(atores.size() == 0){
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return atores;
    }




    // Demais métodos da classe
}