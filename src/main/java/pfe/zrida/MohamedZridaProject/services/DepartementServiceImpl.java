package pfe.zrida.MohamedZridaProject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.repositories.DepartementRepository;

import java.util.List;

@Slf4j
@Service
public class DepartementServiceImpl implements IDepartementService{
    @Autowired
    DepartementRepository departementRepository;
    public List<Departement> retrieveAllDepartements(){
        return (List<Departement>) departementRepository.findAll();
    }

    public Departement addDepartement (Departement d){
        return departementRepository.save(d);
    }

    public   Departement updateDepartement (Departement d){
        return departementRepository.save(d);
    }

    public  Departement retrieveDepartement (Integer idDepart){
        return departementRepository.findById(idDepart).get();
    }
    public  void deleteDepartement(Integer idDepartement){
        Departement d=retrieveDepartement(idDepartement);
        departementRepository.delete(d);
    }
}
