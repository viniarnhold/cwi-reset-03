package br.com.cwi.reset.viniciusarnhold.repository;

import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.enums.StatusCarreira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {
    List<Ator> findAll();
    Ator findByNome(String nome);
    List<Ator> findByStatusCarreira(StatusCarreira statusCarreira);
    Boolean existsByNome(String nome);

}
