package pfe.zrida.MohamedZridaProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pfe.zrida.MohamedZridaProject.entities.Universite;
@Repository
public interface UniversiteRepository extends CrudRepository<Universite,Integer> {
}
