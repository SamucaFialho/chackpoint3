package br.com.github.checkpoint3.dto.dtoconsulta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaRequestUpdate {

       private Long id;
    private LocalDateTime data_consulta;
    private String status_consulta;
    private BigDecimal quantidade_horas;
    private BigDecimal valor_consulta;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getData_consulta() {
        return data_consulta;
    }
    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }
    public String getStatus_consulta() {
        return status_consulta;
    }
    public void setStatus_consulta(String status_consulta) {
        this.status_consulta = status_consulta;
    }
    public BigDecimal getQuantidade_horas() {
        return quantidade_horas;
    }
    public void setQuantidade_horas(BigDecimal quantidade_horas) {
        this.quantidade_horas = quantidade_horas;
    }
    public BigDecimal getValor_consulta() {
        return valor_consulta;
    }
    public void setValor_consulta(BigDecimal valor_consulta) {
        this.valor_consulta = valor_consulta;
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