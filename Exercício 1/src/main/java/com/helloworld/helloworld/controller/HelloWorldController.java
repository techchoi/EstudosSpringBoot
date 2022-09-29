package com.helloworld.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @GetMapping()
    public String helloWorld(){
        return "Hello World"; //aqui vc chama o método para retornar a string, mas pode ser objeto ou inteiro e etc.
    }

}
