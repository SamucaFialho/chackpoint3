package br.com.github.checkpoint3.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaRequestCreate;
import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaRequestUpdate;
import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaResponse;
import br.com.github.checkpoint3.service.ConsultaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequestCreate dto){
        return ResponseEntity.status(201).body(new ConsultaResponse().toDto(consultaService.createConsulta(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long id){
        return consultaService.getConsultaById(id)
        .map(p -> new ConsultaResponse().toDto(p))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@RequestBody ConsultaRequestUpdate dto, @PathVariable Long id){
        return consultaService.UpdateConsulta(id, dto)
        .map(p -> new ConsultaResponse().toDto(p))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean result = consultaService.deleteConsulta(id);

        if (result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity <List<ConsultaResponse>> findAll(){
        List<ConsultaResponse> response = consultaService.getAll().stream()
        .map(p -> new ConsultaResponse().toDto(p))
        .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
