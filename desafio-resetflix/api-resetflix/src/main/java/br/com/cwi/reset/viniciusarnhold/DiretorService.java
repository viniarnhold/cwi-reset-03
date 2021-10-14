package br.com.cwi.reset.viniciusarnhold;

import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {
        Diretor diretor = new Diretor();
        if (!diretorRequest.getNome().equals(null)) {
            diretor.setNome(diretorRequest.getNome());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo nome");
        }

        if (!diretorRequest.getDataNascimento().equals(null)) {
            diretor.setDataNascimento(diretorRequest.getDataNascimento());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo dataNascimento");
        }

        if (!diretorRequest.getAnoInicioAtividade().equals(null)) {
            diretor.setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());
        } else {
            throw new Exception("Campo obrigatório não informado. Favor informar o campo anoInicioAtividade");
        }

        fakeDatabase.persisteDiretor(diretor);
    }

        public List listarDiretores() throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : fakeDatabase.recuperaDiretores()){
                diretores.add(diretor);

                if(diretores.size() == 0){
                    throw new Exception("Nenhum diretor cadastrado, favor cadastar diretores.");
                }
            }
            return diretores;
        }
        public List listarDiretores(String filtroNome) throws Exception {
            List<Diretor> diretores = new ArrayList<>();

            for(Diretor diretor : fakeDatabase.recuperaDiretores()){
                if(diretor.getNome().equals(filtroNome)) {
                        diretores.add(diretor);
                    if (diretores.size() == 0) {
                        throw new Exception("Diretor não encontrado com filtro " + filtroNome + ", favor informar outro nome");
                    }
                }
            }
            return diretores;
        }

    public Diretor consultarAtor(Integer id) throws Exception{
        Diretor diretorConsultado = null;
        for (Diretor diretor : fakeDatabase.recuperaDiretores()) {
            if (diretor.getId() == id) {
                diretorConsultado = diretor;
            }
        }
        if(diretorConsultado == null) {
            throw new Exception("Nenhum diretor encontrado com o parâmetro " + id + ", favor verifique os parâmetros informados.");
        }
        return diretorConsultado;
    }

    // Demais métodos da classe
}
