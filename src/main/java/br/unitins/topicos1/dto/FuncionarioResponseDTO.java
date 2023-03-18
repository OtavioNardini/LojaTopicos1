package br.unitins.topicos1.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.topicos1.model.Funcionario;

public class FuncionarioResponseDTO {

    private Long id;
    private String nome;
    private Map<String, Object> pessoa;

    public FuncionarioResponseDTO(Funcionario funcionario){
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.pessoa = new HashMap<String, Object>();
        this.pessoa.put("nome", funcionario.getPessoa().getNome());
        this.pessoa.put("cpf", funcionario.getPessoa().getCpf());
        
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

    public Map<String, Object> getPessoa() {
        return pessoa;
    }

    public void setPessoa(Map<String, Object> pessoa) {
        this.pessoa = pessoa;
    }

    
}
