package pfe.zrida.MohamedZridaProject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.services.IDepartementService;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/departement")
@Tag(name = "Departement 🏢 Management")
public class DepartementRestController {
    IDepartementService departementService;
    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartements() {
        List<Departement> listDepartements = departementService.retrieveAllDepartements();
        return listDepartements;
    }
    @GetMapping("/retrieve-departement/{departement-id}")
    public Departement retrieveDepartement(@PathVariable("departement-id") Integer departementId) {
        return departementService.retrieveDepartement(departementId);
    }

    @PostMapping("/add-departement")
    public Departement addDepartement(@RequestBody Departement d) {
        Departement departement = departementService.addDepartement(d);
        return departement;
    }

    @DeleteMapping("/remove-departement/{departement-id}")
    public void removeDepartement(@PathVariable("departement-id") Integer departementId) {
        departementService.deleteDepartement(departementId);
    }

    // http://localhost:8089/Kaddem/departement/update-departement
    @PutMapping("/update-departement")
    public Departement updateDepartement(@RequestBody Departement e) {
        Departement departement= departementService.updateDepartement(e);
        return departement;
    }
}