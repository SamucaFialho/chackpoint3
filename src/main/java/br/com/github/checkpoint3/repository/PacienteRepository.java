package br.com.github.checkpoint3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.github.checkpoint3.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}