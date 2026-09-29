package nb.sb_nameday_rest.repository;

import nb.sb_nameday_rest.model.Nameday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamedayRepository extends CrudRepository<Nameday, Integer> {

}