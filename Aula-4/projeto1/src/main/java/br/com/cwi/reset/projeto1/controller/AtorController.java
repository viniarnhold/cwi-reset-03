package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @Autowired
    AtorService atorService;

    @PostMapping
    public void cadastrarAtor(@RequestBody Ator ator){
        atorService.cadastrarAtor(ator);
        ResponseEntity.ok().build();
    }

    @GetMapping("/{nome}")
    public Ator consultarAtor(String nome){
        return atorService.consultarAtor(nome);
    }

    @GetMapping
    public Ator consultarAtor(@RequestParam Integer quantidadeOscar){
        return atorService.consultarAtor(quantidadeOscar);
    }

    @DeleteMapping
    public void deletarAtor(@PathVariable Integer id){
        atorService.deletarAtor(id);
    }

    public void consultarAtor(@RequestParam )


}
