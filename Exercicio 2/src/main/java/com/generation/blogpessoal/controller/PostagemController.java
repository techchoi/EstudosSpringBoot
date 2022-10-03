package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //origem de acesso "*" = tudo, para não ficar limitado na porta 8080. Aqui é uma estrutura de framework
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }
    @GetMapping("/{id}")//somente no id será necessário essa chaves por ser um identificador unico
    public ResponseEntity<Postagem> getById(@PathVariable Long id){//-> simbulo de lambda
        return postagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
