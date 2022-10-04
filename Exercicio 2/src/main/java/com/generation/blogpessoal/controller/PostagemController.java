package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.PostagemModel;
import com.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //origem de acesso "*" = tudo, para não ficar limitado na porta 8080. Aqui é uma estrutura de framework
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<PostagemModel>> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")//somente no id será necessário essa chaves por ser um identificador unico
    public ResponseEntity<PostagemModel> getById(@PathVariable Long id) {//-> simbulo de lambda
        return postagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<PostagemModel>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
}

    @PostMapping
    public ResponseEntity<PostagemModel>post(@Valid @RequestBody PostagemModel postagemModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagemModel));
    }



     @PutMapping
     public ResponseEntity<PostagemModel> put(@Valid@RequestBody PostagemModel postagemModel){
         return postagemRepository.findById(postagemModel.getId())
                 .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                         .body(postagemRepository.save(postagemModel)))
                 .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
            Optional<PostagemModel> postagem = postagemRepository.findById(id);
            if(postagem.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            postagemRepository.deleteById(id);
        }
}
