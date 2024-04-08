package com.api_controle_acesso.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.api_controle_acesso.services.CursoService;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;


    
}
