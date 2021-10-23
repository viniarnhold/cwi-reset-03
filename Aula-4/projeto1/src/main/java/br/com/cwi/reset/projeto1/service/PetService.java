package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepositoryImpl petRepository;

    public Pet salvar(Pet pet) throws Exception {
        Pet petExistente = petRepository.buscarPorNome(pet.getNome());
        if (petExistente == null){
            petRepository.salvar(pet);
        } else {
            throw new Exception("Já existe um Pet com o nome " + pet.getNome());
        }
        return pet;

    }
        public List<Pet> listarPets(){
            return petRepository.listarPets();
        }

        public Pet buscarPorNome(String nome){
            return petRepository.buscarPorNome(nome);
        }

        public void deletar(String nome) throws Exception {
            Pet pet = buscarPorNome(nome);

            if (pet != null){
                petRepository.deletar(pet);
            } else {
                throw new Exception("Não existe Pet cadastrado com o nome " + nome);
            }
        }

        public void atualizarPet(Pet pet) {
            petRepository.atualizarPet(pet);
        }
}
