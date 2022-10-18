package com.generation.blogpessoal.repository;


import com.generation.blogpessoal.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {
    public List<TemaModel> findAllByDescricaoContainingIgnoreCase(@Param("tema") String descricao);
}
