package br.com.github.checkpoint3.dto.dtoprofissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.github.checkpoint3.dto.dtoconsulta.ConsultaResponse;
import br.com.github.checkpoint3.model.Profissional;

public class ProfissinalResponse {

    private Long id;
    private List<ConsultaResponse> consulta;
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    // public List<ConsultaResponse> getConsultas(){
    //     return consulta;
    // }

    // public void setConsulta(List<ConsultaResponse> consulta){
    //     this.consulta = consulta;
    // }

    public ProfissinalResponse toDto(Profissional p){
        this.setId(p.getId());
        this.setNome(p.getNome());
        this.setEspecialidade(p.getEspecialidade());
        this.setValor_hora(p.getValor_hora());
        this.setCreated_at(p.getCreated_at());
        this.setUpdated_at(p.getUpdated_at());
        return this;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public BigDecimal getValor_hora() {
        return valor_hora;
    }
    public void setValor_hora(BigDecimal valor_hora) {
        this.valor_hora = valor_hora;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}