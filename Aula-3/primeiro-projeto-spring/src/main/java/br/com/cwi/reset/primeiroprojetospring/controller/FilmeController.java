package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    public static List<Filme> filmes = new ArrayList<>();

    @GetMapping
    public List<Filme> consultarFilmes(){
        return filmes;
    }

    public Filme verificarFilmePorNome(String nomeFilme){
        for(Filme filmeEncontrado : filmes){
            if(filmeEncontrado.getNome().equals(nomeFilme)){
                return filmeEncontrado;
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = verificarFilmePorNome(filme.getNome());
        if(filmeExistente == null){
            filmes.add(filme);
        } else{
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(filme);
    }

    @GetMapping("/{nome}")
    public Filme filmeConsultaPorNome(@PathVariable String nome){
        Filme filmeConsultado = verificarFilmePorNome(nome);
        return filmeConsultado;
    }

    @DeleteMapping("/{nome}")
    public void removerFilme(@PathVariable String nome) {
        Filme filmeConsultado = verificarFilmePorNome(nome);
        filmes.remove(filmeConsultado);
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme){
        Filme filmeConsultado = verificarFilmePorNome(filme.getNome());
        if(filmeConsultado != null){
            filmes.remove(filmeConsultado);
            filmes.add(filme);
        }
        return filme;
    }
}
