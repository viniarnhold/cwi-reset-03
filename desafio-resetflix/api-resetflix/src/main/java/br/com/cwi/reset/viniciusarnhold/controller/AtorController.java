package br.com.cwi.reset.viniciusarnhold.controller;

import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.request.AtorRequest;
import br.com.cwi.reset.viniciusarnhold.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    public ResponseEntity criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        atorService.criarAtor(atorRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/em_atividade")
    public List<Ator> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
        List<Ator> atoresEcontrados = atorService.listarAtoresEmAtividade(filtroNome);

        return atoresEcontrados;
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> listarAtores() throws Exception {
        return atorService.consultarAtores();
    }

    @PutMapping("/{id}")
    public void atualizarAtor(@PathVariable Integer id, @RequestBody AtorRequest atorRequest) throws Exception {
        atorService.atualizarAtor(id, atorRequest);
        ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable Integer id) throws Exception {
        atorService.deletarAtor(id);
        ResponseEntity.ok().build();
    }
}

