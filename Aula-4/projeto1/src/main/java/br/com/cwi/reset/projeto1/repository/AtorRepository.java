package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository {

    Ator findByNome(String nome);

    List<Ator> listAll();

    Ator findByNumeroOscar(Integer numeroOscars);

    Ator findByAnoNascimento(Integer anoNascimento);

}
