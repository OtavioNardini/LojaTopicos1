package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.repository.PessoaRepository;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Inject
    private PessoaRepository repository;

    @GET
    public List<Pessoa> getAll() {

        // seleciona todas as pessoas do banco de dados
        return Pessoa.findAll().list();

    }

    @POST
    @Transactional
    public Pessoa insert(Pessoa pessoa) {

        repository.persist(pessoa);

        return pessoa;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Pessoa uptadte(@PathParam("id") Long id, Pessoa pessoa) {

        Pessoa entity = Pessoa.findById(id);

        entity.setCpf(pessoa.getCpf());
        entity.setNome(pessoa.getNome());

        return entity;
    }

    @GET
    @Path("/count")
    public long count() {
        return repository.count();
    }

}