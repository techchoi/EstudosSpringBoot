package com.helloworld.helloworld.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/bsm")
public class BSMController {
    @GetMapping()
    public ArrayList<String> bsm(){
        ArrayList<String> listaBsm = new ArrayList<>();
        listaBsm.add("Responsabilidade pessoal");
        listaBsm.add("Proatividade");
        listaBsm.add("Persistência");
        listaBsm.add("Mentalidade de crescimento");
        listaBsm.add("Orientação ao futuro");
        listaBsm.add("Trabalho em equipe");

        return listaBsm;
    }

}

