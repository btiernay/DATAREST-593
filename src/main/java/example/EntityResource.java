package example;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
public class EntityResource {

	@Autowired
	private EntityRepository repository;

	@RequestMapping(method = POST, value = "/entities")
	public ResponseEntity<Entity> save(@Valid @RequestBody Entity entity) {
		return ResponseEntity.ok(repository.save(entity));
	}

}
