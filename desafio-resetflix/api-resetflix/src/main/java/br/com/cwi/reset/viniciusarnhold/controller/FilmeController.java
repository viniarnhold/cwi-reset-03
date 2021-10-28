package br.com.cwi.reset.viniciusarnhold.controller;

import br.com.cwi.reset.viniciusarnhold.domain.Filme;
import br.com.cwi.reset.viniciusarnhold.request.FilmeRequest;
import br.com.cwi.reset.viniciusarnhold.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public ResponseEntity criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Filme> consultarFilmes(@RequestParam(required = false) String nomeFilme,
                                       @RequestParam(required = false) String nomeDiretor,
                                       @RequestParam(required = false) String nomePersonagem,
                                       @RequestParam(required = false) String nomeAtor) throws Exception {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);

    }

    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Integer id) throws Exception {
        filmeService.removerFilme(id);
        ResponseEntity.ok().build();
    }
}