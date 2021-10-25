package br.com.cwi.reset.viniciusarnhold.controller;

import br.com.cwi.reset.viniciusarnhold.FakeDatabase;
import br.com.cwi.reset.viniciusarnhold.domain.Diretor;
import br.com.cwi.reset.viniciusarnhold.request.DiretorRequest;
import br.com.cwi.reset.viniciusarnhold.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    public ResponseEntity cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        diretorService.cadastrarDiretor(diretorRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception {
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }

}
