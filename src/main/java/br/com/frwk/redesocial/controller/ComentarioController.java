package br.com.frwk.redesocial.controller;

import br.com.frwk.redesocial.dto.ComentarioDTO;
import br.com.frwk.redesocial.service.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redesocial/comentarios")
public class ComentarioController {

    @Autowired
    IComentarioService service;


    @PostMapping
    public ResponseEntity<ComentarioDTO> cadastrar(@RequestBody ComentarioDTO to) {
        ComentarioDTO comentario = service.salvar(to);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluir(@PathVariable(value = "id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ComentarioDTO>> consultar() {
        List<ComentarioDTO> comentarios = service.consultar();
        return ResponseEntity.ok(comentarios);
    }
}
