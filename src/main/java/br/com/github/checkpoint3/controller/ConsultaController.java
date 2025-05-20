package br.com.github.checkpoint3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaRequestCreate;
import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaResponse;
import br.com.github.checkpoint3.repository.PacienteRepository;
import br.com.github.checkpoint3.service.ConsultaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequestCreate dto){
        return ResponseEntity.status(201).body(new ConsultaResponse().toD)
    }
}
