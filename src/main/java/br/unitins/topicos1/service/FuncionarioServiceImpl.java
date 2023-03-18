package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;


import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.repository.PessoaRepository;
import br.unitins.topicos1.repository.FuncionarioRepository;


@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService{

    @Inject
    FuncionarioRepository funcionarioRepository;

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    Validator validator;

    @Override
    public List<FuncionarioResponseDTO> getAll() {
        List<Funcionario> list = funcionarioRepository.listAll();
        return list.stream().map(FuncionarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        if (funcionario == null)
            throw new NotFoundException("Funcionario não encontrado.");
        return new FuncionarioResponseDTO(funcionario);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO create(FuncionarioDTO funcionarioDTO) {
        Set<ConstraintViolation<FuncionarioDTO>> violations = validator.validate(funcionarioDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Funcionario entity = new Funcionario();
        entity.setNome(funcionarioDTO.getNome());
        entity.setPessoa(pessoaRepository.findById(funcionarioDTO.getIdPessoa()));
        funcionarioRepository.persist(entity);

        return new FuncionarioResponseDTO(entity);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO update(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario entity = funcionarioRepository.findById(id);

        entity.setNome(funcionarioDTO.getNome());
        entity.setPessoa(pessoaRepository.findById(funcionarioDTO.getIdPessoa()));

        return new FuncionarioResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDTO> findByNome(String nome) {
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        return list.stream().map(FuncionarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return funcionarioRepository.count();
    }
    
}
