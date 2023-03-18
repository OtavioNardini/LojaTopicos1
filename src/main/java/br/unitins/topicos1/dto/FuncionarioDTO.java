package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuncionarioDTO {
    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;
    
    @NotNull(message = "O campo idPessoa deve ser informado.")
    private Long idPessoa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}
