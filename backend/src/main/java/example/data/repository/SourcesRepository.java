package example.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import example.data.entity.Source;

@Transactional
public interface SourcesRepository extends CrudRepository<Source, Integer> {

}
