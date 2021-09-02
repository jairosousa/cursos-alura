package br.com.alura.resource;

import br.com.alura.model.Usuario;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @Autor Jairo Nascimento
 * @Created 31/08/2021 - 16:40
 */
@Path("/usuarios")
public class UsuarioResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        Usuario.adicionar(usuario);
    }
}
