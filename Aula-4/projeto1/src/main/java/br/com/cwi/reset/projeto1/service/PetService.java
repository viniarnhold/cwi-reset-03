package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRepositoryBd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

//    @Autowired
//    private PetRepositoryImpl petRepository;

    @Autowired
    private PetRepositoryBd petRepository;


    public Pet save(Pet pet) throws Exception {
        Pet petExistente = petRepository.findByNome(pet.getNome());
        if (petExistente == null){
            petRepository.save(pet);
        } else {
            throw new Exception("Já existe um Pet com o nome " + pet.getNome());
        }
        return pet;

    }
        public List<Pet> listarPets(){
            return petRepository.findAll();
        }

        public Pet buscarPorNome(String nome){
            return petRepository.findByNome(nome);
        }

        public void deletar(String nome) throws Exception {
            Pet pet = buscarPorNome(nome);

            if (pet != null){
                petRepository.delete(pet);
            } else {
                throw new Exception("Não existe Pet cadastrado com o nome " + nome);
            }
        }

        public Pet atualizarPet(Pet pet) {
            Optional<Pet> petCadastrado = petRepository.findById(pet.getId());
            if (petCadastrado != null){
                return petRepository.save(pet);
            }
            return petRepository.save(pet);
        }
}
