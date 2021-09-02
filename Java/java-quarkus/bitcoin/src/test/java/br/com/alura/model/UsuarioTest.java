package br.com.alura.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 02/09/2021 - 17:57
 */
@QuarkusTest
class UsuarioTest {

    @Test
    public void testarSeFindByIdOptionalretornaUsuarioCorreto() {
        PanacheMock.mock(Usuario.class);

        Usuario u = new Usuario();
        Optional<PanacheEntityBase> usuario = Optional.of(u);

        Mockito.when(Usuario.findByIdOptional(1)).thenReturn(usuario);

        Assertions.assertSame(u, Usuario.findByIdOptional(1).get());
    }
}