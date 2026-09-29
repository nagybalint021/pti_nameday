package nb.sb_nameday_rest.repository;

import nb.sb_nameday_rest.model.Nameday;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NamedayRepository extends CrudRepository<Nameday, Integer> {
    @Query("SELECT * FROM nameday WHERE name = :name")
    Nameday findByName(@Param("name") String name);

    @Query("SELECT * FROM nameday WHERE date = :date")
    Nameday findByDate(@Param("date") String date);
}