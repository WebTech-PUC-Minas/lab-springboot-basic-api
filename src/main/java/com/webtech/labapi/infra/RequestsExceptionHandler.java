package com.webtech.labapi.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//padronização das respostas para diversos tipos de exceções

@RestControllerAdvice  //indica: chamar essa classe toda vez ao lançar uma exceção
public class RequestsExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class) //(indicamos dentro do parâmetro o tipo de exceção que irá tratar)
    public ResponseEntity threat404(){ //404 = conteúdo não encontrado
        return ResponseEntity.badRequest().body("Dado não encontrado.");
    }
}
