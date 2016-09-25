package facts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import facts.dbo.Source;
@Transactional
public interface SourcesDAO extends CrudRepository<Source, Integer> {

}
