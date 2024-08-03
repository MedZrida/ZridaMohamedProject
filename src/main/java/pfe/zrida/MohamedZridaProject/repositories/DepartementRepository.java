package pfe.zrida.MohamedZridaProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pfe.zrida.MohamedZridaProject.entities.Departement;
@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer> {
}
