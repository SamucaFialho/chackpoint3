package br.com.github.checkpoint3.dto;

public enum ProfissionalStatus {
    AGENDADA("Consulta agendada"),
    REALIZADA("Consulta realizada"),
    CANCELADA("Consulta cncelada");

    ProfissionalStatus(String mensagem){
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    

}
