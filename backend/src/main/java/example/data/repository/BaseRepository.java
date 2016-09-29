package example.data.repository;
import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
 
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
 
    void delete(T deleted);
 
    Stream<T> findAll();
     
    Optional<T> findOne(ID id);
 
    T save(T persisted);
}