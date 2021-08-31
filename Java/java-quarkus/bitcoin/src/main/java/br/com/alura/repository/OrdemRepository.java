package br.com.alura.repository;

import br.com.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Autor Jairo Nascimento
 * @Created 31/08/2021 - 16:53
 */
@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
}
