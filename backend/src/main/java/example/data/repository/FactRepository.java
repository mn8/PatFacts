package example.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import example.data.entity.Fact;


@Transactional
public interface FactRepository extends CrudRepository<Fact, Integer>{

}
