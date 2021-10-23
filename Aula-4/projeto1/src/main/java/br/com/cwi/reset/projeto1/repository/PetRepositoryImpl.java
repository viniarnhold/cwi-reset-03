package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository{

    private static List<Pet> pets = new ArrayList<>();

    public List<Pet> listarPets(){
        return pets;
    }

    public Pet buscarPorNome(String nome){
        Pet petEncontrado = null;
        for (Pet pet : pets){
            if(pet.getNome().equals(nome)){
                petEncontrado = pet;
            }
        }
        return petEncontrado;
    }

    public Pet salvar(Pet pet){
        pets.add(pet);
        return pet;
    }

    public void deletar(Pet pet){
        pets.remove(pet);
    }

    public void atualizarPet(Pet pet) {
        Pet petCadastrado = buscarPorNome(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
        }
    }


}
