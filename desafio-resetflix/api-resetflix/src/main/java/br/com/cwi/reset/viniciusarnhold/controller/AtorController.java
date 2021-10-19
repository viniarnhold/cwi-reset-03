package br.com.cwi.reset.viniciusarnhold.controller;

import br.com.cwi.reset.viniciusarnhold.FakeDatabase;
import br.com.cwi.reset.viniciusarnhold.domain.Ator;
import br.com.cwi.reset.viniciusarnhold.request.AtorRequest;
import br.com.cwi.reset.viniciusarnhold.services.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    public ResponseEntity criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
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

    //demais métodos
}
