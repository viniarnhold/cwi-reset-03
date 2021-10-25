package br.com.cwi.reset.viniciusarnhold.repository;

import br.com.cwi.reset.viniciusarnhold.domain.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer>{

    List<Estudio> findAll();

}
