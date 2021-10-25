package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepositoryBd extends CrudRepository {
    Filme findByNome(String nome);
}
