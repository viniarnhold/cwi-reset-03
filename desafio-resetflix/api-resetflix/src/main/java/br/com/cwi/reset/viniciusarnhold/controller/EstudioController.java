package br.com.cwi.reset.viniciusarnhold.controller;

import br.com.cwi.reset.viniciusarnhold.domain.Estudio;
import br.com.cwi.reset.viniciusarnhold.request.EstudioRequest;
import br.com.cwi.reset.viniciusarnhold.services.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    public ResponseEntity criarEstudio(@RequestBody @Valid EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return estudioService.listarEstudio(filtroNome);
    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(id);
    }
}
