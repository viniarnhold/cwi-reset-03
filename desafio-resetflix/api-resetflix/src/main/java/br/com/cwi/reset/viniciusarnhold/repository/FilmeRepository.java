package br.com.cwi.reset.viniciusarnhold.repository;

import br.com.cwi.reset.viniciusarnhold.domain.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer>{
    List<Filme> findAll();
}
