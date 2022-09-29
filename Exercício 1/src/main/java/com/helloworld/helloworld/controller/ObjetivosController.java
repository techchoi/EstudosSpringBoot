package com.helloworld.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
    @GetMapping()
    public ArrayList<String> exibirObjetivosDeAprendizagem(){
        ArrayList<String> listaObjetivos = new ArrayList<>();
        listaObjetivos.add("Aprender liguagem de programação Java");
        listaObjetivos.add("Aprimorar as Soft Skills");
        listaObjetivos.add("Aprender react");
        listaObjetivos.add("Aprender banco de dados");
        return listaObjetivos;
    }

}
