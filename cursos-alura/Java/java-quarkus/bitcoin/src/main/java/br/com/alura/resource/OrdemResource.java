package br.com.alura.resource;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 31/08/2021 - 16:57
 */
@Path("/ordens")
public class OrdemResource {

    @Inject
    OrdemService ordemService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem) {
        ordemService.inserir(securityContext, ordem);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar() {
        return ordemService.listar();
    }
}
