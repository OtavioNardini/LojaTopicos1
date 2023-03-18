package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;

public interface FuncionarioService {

     // recursos basicos
     List<FuncionarioResponseDTO> getAll();

     FuncionarioResponseDTO findById(Long id);
 
     FuncionarioResponseDTO create(FuncionarioDTO productDTO);
 
     FuncionarioResponseDTO update(Long id, FuncionarioDTO productDTO);
 
     void delete(Long id);
 
     // recursos extras
 
     List<FuncionarioResponseDTO> findByNome(String nome);
 
     long count();
 
    
}
