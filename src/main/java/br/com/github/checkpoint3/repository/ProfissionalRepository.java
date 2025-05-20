package br.com.github.checkpoint3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.github.checkpoint3.dto.ProfissionalStatus;
import br.com.github.checkpoint3.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
    public List<Profissional> findByStatus(ProfissionalStatus status);
}