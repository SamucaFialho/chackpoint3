package br.com.github.checkpoint3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaRequestCreate;
import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaRequestUpdate;
import br.com.github.checkpoint3.model.Consulta;
import br.com.github.checkpoint3.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta createConsulta(ConsultaRequestCreate dto){
        return consultaRepository.save(dto.toModel());
    }

    public Optional<Consulta> getConsultaById(Long id){
        return consultaRepository.findById(id);
    }

    public List<Consulta> getAll(){
        return consultaRepository.findAll();
    }

    public Optional<Consulta> UpdateConsulta(Long id, ConsultaRequestUpdate dto){
        return consultaRepository.findById(id)
        .map(p -> consultaRepository.save(dto.toModel(p)));
    }

    public boolean deleteConsulta(Long id){
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
