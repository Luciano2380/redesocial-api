package br.com.frwk.redesocial.controller;

import br.com.frwk.redesocial.dto.FotoDTO;
import br.com.frwk.redesocial.dto.PostagemDTO;
import br.com.frwk.redesocial.service.IFotoService;
import br.com.frwk.redesocial.service.IPostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redesocial/postagens")
public class PostagemController {

    @Autowired
    IPostagemService service;
    @PostMapping
    public ResponseEntity<PostagemDTO> cadastrar(@RequestBody PostagemDTO to) {
        PostagemDTO postagem = service.salvar(to);
        return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluir(@PathVariable(value = "id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<PostagemDTO>> consultar() {
        List<PostagemDTO> postagens = service.consultar();
        return ResponseEntity.ok(postagens);
    }
}
