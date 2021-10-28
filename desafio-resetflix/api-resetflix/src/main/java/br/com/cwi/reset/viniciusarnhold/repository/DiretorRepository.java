package br.com.cwi.reset.viniciusarnhold.repository;

import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {
    List<Diretor> findAll();

    Optional<Diretor> findByNome(String nome);

    Boolean existsByNome(String nome);
}
