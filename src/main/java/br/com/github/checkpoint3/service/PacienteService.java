package br.com.github.checkpoint3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.github.checkpoint3.dto.dtoPaciente.PacienteRequestCreate;
import br.com.github.checkpoint3.dto.dtoPaciente.PacienteRequestUpdate;
import br.com.github.checkpoint3.model.Paciente;


@Service
public class PacienteService {


    private List<Paciente> pacientes = new ArrayList<>();
    private Long sequence = 1L;

    public Paciente createPaciente(PacienteRequestCreate dto){
        Paciente paciente = new Paciente();
        paciente.setId(sequence++);
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setEndereco(dto.getEndereco());
        paciente.setNome(dto.getNome());
        paciente.setTelefone(dto.getTelefone());
        pacientes.add(paciente);
        return paciente;
    }

    public Optional<Paciente> getPacienteById(Long id) {
        
         return pacientes.stream()
         .filter(p -> p.getId().equals(id))
         .findFirst();
        
    }

    public List<Paciente> getAll(){
        return pacientes;
    }

    public Optional<Paciente> UpdatePaciente(Long id, PacienteRequestUpdate dto){
        return pacientes.stream().filter(p -> p.getId().equals(id))
                  .findFirst()
                  .map(p -> {
                      p.setId(dto.getId());
                      p.setBairro(dto.getBairro());
                      p.setEmail(dto.getEmail());
                      p.setEndereco(dto.getEndereco());
                      p.setNome(dto.getNome());
                      p.setTelefone(dto.getTelefone());
                     return p;
               });} 

    public boolean DeletePaciente(Long id){
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
        
    
    

}