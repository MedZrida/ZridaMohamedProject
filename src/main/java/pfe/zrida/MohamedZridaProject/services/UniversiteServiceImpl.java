package pfe.zrida.MohamedZridaProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.entities.Universite;
import pfe.zrida.MohamedZridaProject.repositories.DepartementRepository;
import pfe.zrida.MohamedZridaProject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartementRepository departementRepository;

    public UniversiteServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Transactional
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }


    public Universite addUniversite(Universite u) {
        return (universiteRepository.save(u));
    }

    @Transactional
    public Universite updateUniversite(Universite u) {
        return (universiteRepository.save(u));
    }

    @Transactional
    public Universite retrieveUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        return u;
    }

    public void deleteUniversite(Integer idUniversite) {
        universiteRepository.delete(retrieveUniversite(idUniversite));
    }

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        u.getDepartements().add(d);
        universiteRepository.save(u);
    }

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        return u.getDepartements();
    }
}