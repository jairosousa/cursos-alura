package br.com.alura.service;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 02/09/2021 - 15:04
 */
@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new RuntimeException("Usuario logado é diferente do userId");
        }

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
