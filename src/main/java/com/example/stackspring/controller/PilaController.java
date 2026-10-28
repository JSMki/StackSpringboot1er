package com.example.stackspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/pila")
public class PilaController {

    // Instancia de la pila que se mantiene en memoria mientras el servidor corre
    private Stack<Character> chars = new Stack<>();

    @PostMapping
    public String agregar(@RequestParam Character valor) {
        chars.push(valor);
        return "Se agrego: " + valor;
    }

    @GetMapping("/pop")
    public String sacar() {
        // Evita que truene con EmptyStackException si la pila no tiene elementos
        if (chars.isEmpty()) {
            return "La pila esta vacia";
        }
        Character sacado = chars.pop();
        return "Se quito: " + sacado;
    }

    @GetMapping
    public Stack<Character> verPila() {
        return chars;
    }
}