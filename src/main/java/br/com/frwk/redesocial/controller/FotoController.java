package br.com.frwk.redesocial.controller;

import br.com.frwk.redesocial.dto.ComentarioDTO;
import br.com.frwk.redesocial.dto.FotoDTO;
import br.com.frwk.redesocial.service.IFotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/redesocial/fotos")
public class FotoController {

    @Autowired
    IFotoService service;


    @PostMapping(path = "/imagem")
    public ResponseEntity uploadImagem( @RequestParam("imagem") MultipartFile request) throws IOException {
          String url = service.upload(request.getBytes(),request.getOriginalFilename());
       return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }

    @PostMapping
    public ResponseEntity<FotoDTO> cadastrar(@RequestBody FotoDTO to) {
        FotoDTO foto = service.salvar(to);
        return ResponseEntity.status(HttpStatus.CREATED).body(foto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluir(@PathVariable(value = "id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FotoDTO>> consultar() {
        List<FotoDTO> fotos = service.consultar();
        return ResponseEntity.ok(fotos);
    }
}
