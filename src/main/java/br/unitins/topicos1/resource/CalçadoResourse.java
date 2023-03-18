package br.unitins.topicos1.resource;

import java.util.List;


import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import br.unitins.topicos1.model.Calçado;

@Path("/calçados")
public class CalçadoResourse {

    // seleciona todas os calçados do banco de dados
    @GET
    public List<Calçado> getAll() {
        return Calçado.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Calçado insert(Calçado calçado) {
        // adiciona o calçado no banco de dados
        calçado.persist();

        return calçado;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Calçado uptadte(@PathParam("id") Long id, Calçado calçado) {

        Calçado entity = Calçado.findById(id);

        entity.setTipo(calçado.getTipo());
        entity.setTamanho(calçado.getTamanho());
        entity.setModelo(calçado.getModelo());
        entity.setMarca(calçado.getMarca());

        return entity;
    }

}
