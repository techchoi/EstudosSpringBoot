package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity //transforma a classe/entidade em tabela
@Table(name = "tb_postagem") //Renomeando a tabela
public class PostagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo título é Obrigatório!")
    @Size(min = 5, max = 100,message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "O atributo texto é Obrigatório!")
    @Size(min =5, max = 100, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
    private String texto;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne //muitos para um
    @JsonIgnoreProperties("postagem")
    private TemaModel tema;

    @ManyToOne
    @JoinColumn(name = "ususario_ID")
    @JsonIgnoreProperties("postagem")
    private Usuario ususario;

    public void setId(Long id) {
        this.id = id;
    }

    public TemaModel getTema() {
        return tema;
    }

    public void setTema(TemaModel tema) {
        this.tema = tema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsusario() {
        return ususario;
    }

    public void setUsusario(Usuario ususario) {
        this.ususario = ususario;
    }
}
