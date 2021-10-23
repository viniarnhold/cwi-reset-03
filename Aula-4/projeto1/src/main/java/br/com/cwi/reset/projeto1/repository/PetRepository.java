package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    List<Pet> listarPets();

    Pet buscarPorNome(String nome);

    Pet salvar(Pet pet);

    void deletar(Pet pet);

    void atualizarPet(Pet pet);
}
