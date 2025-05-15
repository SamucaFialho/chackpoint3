package br.com.github.checkpoint3.dto.dtoprofissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.github.checkpoint3.model.Profissional;

public class ProfissionalRequestUpdate {

    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Profissional toModel(Profissional p){
        p.setNome(this.nome);
        p.setEspecialidade(this.especialidade);
        p.setValor_hora(this.valor_hora);
        p.setUpdated_at(this.updated_at);
        p.setCreated_at(this.created_at);
        return p;
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