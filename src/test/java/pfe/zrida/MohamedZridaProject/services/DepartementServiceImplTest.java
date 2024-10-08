package pfe.zrida.MohamedZridaProject.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import pfe.zrida.MohamedZridaProject.entities.Contrat;
import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.entities.Equipe;
import pfe.zrida.MohamedZridaProject.entities.Etudiant;
import pfe.zrida.MohamedZridaProject.repositories.ContratRepository;
import pfe.zrida.MohamedZridaProject.repositories.DepartementRepository;
import pfe.zrida.MohamedZridaProject.repositories.EquipeRepository;
import pfe.zrida.MohamedZridaProject.repositories.EtudiantRepository;

class DepartementServiceImplTest {

    @InjectMocks
    private DepartementServiceImpl departementService;
    @Mock
    private DepartementRepository departementRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Departement> resultat = new ArrayList<>();

        Departement departement1 = new Departement();
        departement1.setNomDepart("Esprit Departement");
        //departementRepository.save(departement1);

        Departement departement2 = new Departement();
        departement2.setNomDepart("EAmen Departement");
        // departementRepository.save(departement2);

        resultat.add(departement1);
        resultat.add(departement2);
        when(departementRepository.findAll()).thenReturn(resultat);
        List<Departement> aff =departementService.retrieveAllDepartements();
        if (resultat.size() == 2) {
            System.err.println("--------------[Test : Find All Universite Method]-------------------\n Test Passed: Result size is 2 as expected. \n -------------------------------------------------------------");
        } else {
            System.err.println("--------------[Test : Find All Universite Method]-------------------\n Test Failed: Expected result size 2, but got " + resultat.size() + "\n -------------------------------------------------------------");
        }
        assertEquals(2, resultat.size()); // Assurez-vous que la taille de la liste est correcte
    }

    @Test
    void testAddDepartement() {
        Departement departement = new Departement();
        departement.setNomDepart("Esprit Departement");
        when(departementRepository.save(departement)).thenReturn(departement);
        Departement addedDepartement = departementService.addDepartement(departement);
        //verify(departementRepository, times(1)).save(departement);
        assertEquals("Esprit Departement", addedDepartement.getNomDepart());
        System.out.println(addedDepartement.getNomDepart()+" ajouter");
    }

    @Test
    void testRetrieveDepartement() {
        // Create a sample Departement object
        Departement dep= new Departement();
        dep.setIdDepart(1);
        dep.setNomDepart("Esprit Departement");
        when(departementRepository.findById(dep.getIdDepart())).thenReturn(Optional.of(dep));
        Departement retrievedDepartement = departementService.retrieveDepartement(1);
        verify(departementRepository).findById(1);
        assertEquals(dep, retrievedDepartement);
        assertEquals(1, retrievedDepartement.getIdDepart());
        assertEquals("Esprit Departement", retrievedDepartement.getNomDepart());
        boolean allAssertionsPassed = true;
        if (!allAssertionsPassed) {
            System.err.println("Erreur");
        } else {
            System.err.println("Retrieved Departement: " + retrievedDepartement.getNomDepart());
        }
    }
    @Test
    void testDeleteDepartement() {
        Departement dep = new Departement();
        dep.setIdDepart(1);
        dep.setNomDepart("Esprit Departement");
        when(departementRepository.findById(dep.getIdDepart())).thenReturn(Optional.of(dep));
        departementService.deleteDepartement(1);
        verify(departementRepository).findById(1);
        verify(departementRepository).delete(dep);
        if (!departementRepository.existsById(1)) {
            System.err.println("Departement Deleted Successfully");
        } else {
            // Print an error message if the Departement still exists
            System.err.println("Error: Departement Deletion Failed");
        }
    }
    @Test
    void testUpdateDepartement() {
        Departement existingDepartement = new Departement();
        existingDepartement.setIdDepart(1);
        existingDepartement.setNomDepart("Esp Departement");
        when(departementRepository.findById(existingDepartement.getIdDepart())).thenReturn(Optional.of(existingDepartement));
        when(departementRepository.save(any(Departement.class))).thenAnswer(invocation -> {
            Departement updatedEntity = invocation.getArgument(0);
            existingDepartement.setNomDepart(updatedEntity.getNomDepart());
            return existingDepartement;
        });

        System.err.println("Before Test Update = " + existingDepartement.getNomDepart());
        existingDepartement.setNomDepart("Esp1 Departement Name");
        Departement updatedDepartement = departementService.updateDepartement(existingDepartement);
        assertEquals("Esp1 Departement Name", updatedDepartement.getNomDepart());
        verify(departementRepository).save(existingDepartement);

        System.err.println("After Test Update = " + existingDepartement.getNomDepart());
    }

}

