package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *
 * @Author: Jairo Nascimento on 21/06/2021 - 17:40
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoRepositoryTest {

  @Autowired
  private CursoRepository repository;

  @Test
  public void deveBuscarCursoBuscarPeloSeuNome() {
    String nomeCurso = "HTML 5";
    Curso curso = repository.findByNome(nomeCurso);

    Assert.assertNotNull(curso);
    Assert.assertEquals(nomeCurso, curso.getNome());
  }

  @Test
  public void naoDeveBuscarCursoBuscarPeloSeuNome() {
    String nomeCurso = "JPA";
    Curso curso = repository.findByNome(nomeCurso);

    Assert.assertNull(curso);
  }
}