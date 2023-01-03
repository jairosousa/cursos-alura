package br.com.alura.microservice.loja.repository;

import br.com.alura.microservice.loja.model.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 05/08/2021 - 12:20
 */
@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
}
