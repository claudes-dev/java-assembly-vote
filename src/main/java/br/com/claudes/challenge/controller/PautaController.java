package br.com.claudes.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("pauta/v1")
public class PautaController {

    @GetMapping("/hello")
    public String helloWord(){

        return "Ola mundo";
    }

}
