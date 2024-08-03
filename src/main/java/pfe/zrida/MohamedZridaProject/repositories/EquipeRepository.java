package pfe.zrida.MohamedZridaProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pfe.zrida.MohamedZridaProject.entities.Equipe;
@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {
}
