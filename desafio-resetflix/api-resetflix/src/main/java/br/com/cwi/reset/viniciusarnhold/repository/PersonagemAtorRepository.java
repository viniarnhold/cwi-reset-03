package br.com.cwi.reset.viniciusarnhold.repository;

import br.com.cwi.reset.viniciusarnhold.domain.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {
}
