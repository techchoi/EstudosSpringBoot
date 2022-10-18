package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.TemaModel;
import com.generation.blogpessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<TemaModel>> getAll() {
        return ResponseEntity.ok(temaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemaModel> getById(@PathVariable Long id) {
        return temaRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<TemaModel>> getByTitle(@PathVariable String descricao) {
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<TemaModel> post(@Valid @RequestBody TemaModel temaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(temaModel));
    }

    @PutMapping
    public ResponseEntity<TemaModel> put(@Valid @RequestBody TemaModel temaModel) {
        return temaRepository.findById(temaModel.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(temaRepository.save(temaModel)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<TemaModel> temaModel = temaRepository.findById(id);
        if (temaModel.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        temaRepository.deleteById(id);

    }
}
