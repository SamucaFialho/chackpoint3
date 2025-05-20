package br.com.github.checkpoint3.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.github.checkpoint3.dto.ProfissionalStatus;
import br.com.github.checkpoint3.dto.dtoprofissional.ProfissionalRequestCreate;
import br.com.github.checkpoint3.dto.dtoprofissional.ProfissionalRequestUpdate;
import br.com.github.checkpoint3.model.Consulta;
import br.com.github.checkpoint3.model.Paciente;
import br.com.github.checkpoint3.model.Profissional;
import br.com.github.checkpoint3.repository.ConsultaRepository;
import br.com.github.checkpoint3.repository.PacienteRepository;
import br.com.github.checkpoint3.repository.ProfissionalRepository;


@Service
public class ProfissionalService {


    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Profissional createProfissional(ProfissionalRequestCreate dto){
        Profissional profissional = new Profissional();
        profissional.setStatus(ProfissionalStatus.AGENDADA);
        profissional.setCreated_at(dto.getCreated_at());
        profissional.setUpdated_at(dto.getUpdated_at());

        List<Consulta> consultas = dto.getConsultas().stream().map(p -> {
        Consulta consulta = new Consulta();

        Paciente paciente = pacienteRepository.findById(p.getId())
        .orElseThrow(() -> 
        new RuntimeException(
            "Paciente Inexistente: " + p.getId()
 ));
            consulta.setPaciente(paciente);
            consulta.setValor_consulta(p.getValor_consulta());
            consulta.setQuantidade_horas(p.getQuantidade_horas());
            consulta.setProfissional(profissional);
            return consulta;
       
        
        
        }).collect(Collectors.toList());

        profissional.setConsulta(consultas);
        return profissionalRepository.save(profissional);
    }
    public Optional<Profissional> getProfissionalById(Long id){
        return profissionalRepository.findById(id);
    }

    public List<Profissional> findAllList(){
        return profissionalRepository.findAll();
    }

    public Optional<Profissional> updateProfissional(Long id, ProfissionalRequestUpdate dto){
        return profissionalRepository.findById(id)
        .map(p -> profissionalRepository.save(dto.toModel(p)));
    }
    public boolean deleteProfissional(Long id){
        if (profissionalRepository.existsById(id)) {
            profissionalRepository.deleteById(id);
            return true;
            
        }
        return false;
    }

    public List<Profissional> findByStatus(ProfissionalStatus status){
        return profissionalRepository.findByStatus(status);
    }
    

}