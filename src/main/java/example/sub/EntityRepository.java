package example.sub;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import example.model.Entity;

public interface EntityRepository extends MongoRepository<Entity, String> {

	Page<Entity> findByName(@Param("name") String name, Pageable pageable);

	Page<Entity> findByValue(@Param("value") String value, Pageable pageable);

	Page<Entity> findByValueAndName(@Param("value") String value,
			@Param("name") String name, Pageable pageable);

	@RestResource(exported = false)
	Entity findByValueAndName(@Param("name") String value,
			@Param("value") String name);

	@Override
	@RestResource(exported = false)
	void delete(String id);

	@Override
	@RestResource(exported = false)
	void delete(Entity entity);

}
