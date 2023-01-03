package br.com.alura.spring.jpa.data.repository;

import br.com.alura.spring.jpa.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Jairo Nascimento on 28/06/2021 - 06:40
 */
@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
