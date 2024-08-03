package pfe.zrida.MohamedZridaProject.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfe.zrida.MohamedZridaProject.entities.Contrat;
import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.entities.Equipe;
import pfe.zrida.MohamedZridaProject.entities.Etudiant;
import pfe.zrida.MohamedZridaProject.repositories.ContratRepository;
import pfe.zrida.MohamedZridaProject.repositories.DepartementRepository;
import pfe.zrida.MohamedZridaProject.repositories.EquipeRepository;
import pfe.zrida.MohamedZridaProject.repositories.EtudiantRepository;

import java.util.List;

@Service
@Slf4j
public class EtudiantServiceImpl implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository ;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    DepartementRepository departementRepository;
    public List<Etudiant> retrieveAllEtudiants(){
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    public Etudiant addEtudiant (Etudiant e){
        return etudiantRepository.save(e);
    }

    public Etudiant updateEtudiant (Etudiant e){
        return etudiantRepository.save(e);
    }

    public Etudiant retrieveEtudiant(Integer  idEtudiant){
        return etudiantRepository.findById(idEtudiant).get();
    }

    public void removeEtudiant(Integer idEtudiant){
        Etudiant e=retrieveEtudiant(idEtudiant);
        etudiantRepository.delete(e);
    }

    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        Contrat c=contratRepository.findById(idContrat).orElse(null);
        Equipe eq=equipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        eq.getEtudiants().add(e);
        return e;
    }

    public 	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
        return  etudiantRepository.findEtudiantsByDepartement_IdDepart((idDepartement));
    }
}
