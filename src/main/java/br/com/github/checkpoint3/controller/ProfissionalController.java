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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.github.checkpoint3.dto.ProfissionalStatus;
import br.com.github.checkpoint3.dto.dtoprofissional.ProfissinalResponse;
import br.com.github.checkpoint3.dto.dtoprofissional.ProfissionalRequestCreate;
import br.com.github.checkpoint3.dto.dtoprofissional.ProfissionalRequestUpdate;
import br.com.github.checkpoint3.model.Profissional;
import br.com.github.checkpoint3.service.ProfissionalService;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    ProfissionalService profissionalService;

    @PostMapping("/{id}")
    public ResponseEntity<ProfissinalResponse> create(@PathVariable Long id,
    @RequestBody ProfissionalRequestCreate dto){
        Profissional profissional = profissionalService.createProfissional(dto);

        ProfissinalResponse response = new ProfissinalResponse().toDto(profissional);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissinalResponse> findById (
        @PathVariable Long id){
            return profissionalService.getProfissionalById(id)
            .map(p -> new ProfissinalResponse().toDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
        }

    @GetMapping("status")
    public ResponseEntity <List<ProfissinalResponse>> findByStatus(ProfissionalStatus status){
        return ResponseEntity.ok(profissionalService.findByStatus((status)).stream()
        .map(p ->  new ProfissinalResponse().toDto(p))
        .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean result = profissionalService.deleteProfissional(id);

        if (result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissinalResponse> update(@PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto){

        return profissionalService.updateProfissional(id, dto)
        .map(p -> new ProfissinalResponse().toDto(p))                   //aqui 
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    ResponseEntity<List<ProfissinalResponse>> findAll(){
        List<ProfissinalResponse> response = profissionalService.findAllList()
        .stream().map(p -> new ProfissinalResponse().toDto(p))
        .collect(Collectors.toList());
        return ResponseEntity.ok(response); 
    }


}