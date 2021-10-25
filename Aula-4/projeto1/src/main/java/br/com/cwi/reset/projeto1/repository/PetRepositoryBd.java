package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepositoryBd extends CrudRepository<Pet, Integer> {

    List<Pet> findAll();

    Pet findByNome(String nome);

    Optional<Pet> findById(Pet pet);
}
