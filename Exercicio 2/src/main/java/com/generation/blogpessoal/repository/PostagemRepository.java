package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.generation.blogpessoal.model.PostagemModel;

import java.util.List;

@Repository //essa interface vai ser utilizado como um repositorio
public interface PostagemRepository extends JpaRepository<PostagemModel,Long> {

    public List <PostagemModel> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
}
