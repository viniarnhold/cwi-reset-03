package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping
    public List<Pet> getPet() {
        return petService.listarPets();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getByNome(@PathVariable String nome) {
        try {
            petService.buscarPorNome(nome);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPet(@RequestBody Pet pet) {
        try {
            petService.salvar(pet);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
        petService.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws Exception {
        petService.deletar(nome);
    }

}
