package pl.mkamola.kerndpa.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mkamola.kerndpa.models.daos.EntryDao;

public interface IEntryRepository extends CrudRepository<EntryDao, Integer> {

}
