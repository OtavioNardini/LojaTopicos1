package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.service.FuncionarioService;

@Path("/funcionarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioResourse {
    @Inject
    FuncionarioService funcionarioService;

    @GET
    public List<FuncionarioResponseDTO> getAll() {
        return funcionarioService.getAll();
    }

    @GET
    @Path("/id")
    public FuncionarioResponseDTO findById(@PathParam("id") Long id){
        return funcionarioService.findById(id);
    }

    @POST
    public Response insert(FuncionarioDTO dto) {
        FuncionarioResponseDTO funcionario = funcionarioService.create(dto);
        return Response.status(Status.CREATED).entity(funcionario).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        FuncionarioResponseDTO funcionario = funcionarioService.update(id, dto);
        return Response.ok(funcionario).build();
    }

    @PUT
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        funcionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    public long count(){
        return funcionarioService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<FuncionarioResponseDTO> search(@PathParam("nome") String nome){
        return funcionarioService.findByNome(nome);
        
    }

    
}
