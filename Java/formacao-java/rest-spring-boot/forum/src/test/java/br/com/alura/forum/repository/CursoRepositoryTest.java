package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *
 * @Author: Jairo Nascimento on 21/06/2021 - 17:40
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Serve para Spring nos testes usar seu database configurado
@ActiveProfiles("test")
public class CursoRepositoryTest {

  @Autowired
  private CursoRepository repository;

  @Autowired
  private TestEntityManager manager;

  @Test
  public void deveBuscarCursoBuscarPeloSeuNome() {
    String nomeCurso = "HTML 5";
    String categoria = "Programação 5";
    Curso curso = new Curso();
    curso.setNome(nomeCurso);
    curso.setCategoria(categoria);

    manager.persist(curso);

    Curso retorno = repository.findByNome(nomeCurso);

    Assert.assertNotNull(retorno);
    Assert.assertEquals(nomeCurso, retorno.getNome());
    Assert.assertEquals(categoria, retorno.getCategoria());
  }

  @Test
  public void naoDeveBuscarCursoBuscarPeloSeuNome() {
    String nomeCurso = "JPA";
    Curso curso = repository.findByNome(nomeCurso);

    Assert.assertNull(curso);
  }
}