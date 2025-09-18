package br.fiap.teste.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TesteController {

    @GetMapping("/saudacao")
    public Map <String, String> saudacao (@RequestParam(defaultValue = "Fiap") String nome) {
        return Map.of("mensagem", "Olá, " + nome);
    }

    @GetMapping("/somar")
    public Map <String, Integer> somar (@RequestParam int a, @RequestParam int b) {
        return Map.of("Resultado ",a + b);
    }

    @GetMapping("/dividir")
    public Map <String, Double> dividir (@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe " +
                    "divisão por zero");
        }
        return Map.of("Resultado", a/b);
    }


}
