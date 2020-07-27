package br.com.frwk.redesocial.controller;

import br.com.frwk.redesocial.dto.PostagemDTO;
import br.com.frwk.redesocial.dto.UsuarioDTO;
import br.com.frwk.redesocial.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/redesocial/usuarios")
public class UsuarioController {

    @Autowired
    IUsuarioService service;


    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO to) {
        UsuarioDTO user = service.cadastrar(to);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
