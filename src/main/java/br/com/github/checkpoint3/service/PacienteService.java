package br.com.github.checkpoint3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.github.checkpoint3.dto.dtoPaciente.PacienteRequestCreate;
import br.com.github.checkpoint3.dto.dtoPaciente.PacienteRequestUpdate;
import br.com.github.checkpoint3.model.Paciente;
import br.com.github.checkpoint3.repository.PacienteRepository;


@Service
public class PacienteService {


    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(PacienteRequestCreate dto){
        return pacienteRepository.save(dto.toModel());
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
        
    }

    public List<Paciente> getAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> UpdatePaciente(Long id, PacienteRequestUpdate dto){
        return pacienteRepository.findById(id)
        .map(p -> pacienteRepository.save(dto.toModel(p)));
        
               } 

    public boolean deletePaciente(Long id){
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
        
    
    

}