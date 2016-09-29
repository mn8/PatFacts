package facts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import facts.dbo.Fact;

@Transactional
public interface FactsDAO extends CrudRepository<Fact, Integer>{

}