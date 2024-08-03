package pfe.zrida.MohamedZridaProject.controllers;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import pfe.zrida.MohamedZridaProject.entities.Contrat;
import pfe.zrida.MohamedZridaProject.services.IContratService;


import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@Tag(name = "Contrat 📝 Management")
public class ContratRestController {
    IContratService contratService;
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrats() {
        List<Contrat> listContrats = contratService.retrieveAllContrats();
        return listContrats;
    }
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Integer contratId) {
        return contratService.retrieveContrat(contratId);
    }

    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        Contrat contrat = contratService.addContrat(c);
        return contrat;
    }

    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Integer contratId) {
        contratService.removeContrat(contratId);
    }

    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat c) {
        Contrat contrat= contratService.updateContrat(c);
        return contrat;
    }

		/*@PutMapping(value = "/assignContratToEtudiant/{ce}/{nomE}/{prenomE}")
		public Contrat assignContratToEtudiant (Contrat ce, String nomE, String prenomE){
		return 	(contratService.affectContratToEtudiant(ce, nomE, prenomE));
		}*/

    @PutMapping(value = "/assignContratToEtudiant/{idContrat}/{nomE}/{prenomE}")
    public Contrat assignContratToEtudiant (Integer idContrat, String nomE, String prenomE){
        //	Contrat c= contratService.affectContratToEtudiant()
        return 	(contratService.affectContratToEtudiant(idContrat, nomE, prenomE));
    }

    //The most common ISO Date Format yyyy-MM-dd — for example, "2000-10-31".
    @GetMapping(value = "/getnbContratsValides/{startDate}/{endDate}")
    public Integer getnbContratsValides(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                        @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        return contratService.nbContratsValides(startDate, endDate);
    }

    //Only no-arg methods may be annotated with @Scheduled
    @Scheduled(cron="0 0 13 * * *")//(cron="0 0 13 * * ?")(fixedRate =21600)
    @PutMapping(value = "/majStatusContrat")
    public void majStatusContrat (){
        //return 	(contratService.affectContratToEtudiant(ce, nomE, prenomE));
        contratService.retrieveAndUpdateStatusContrat();

    }

    //public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate)

    @GetMapping("/calculChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    @ResponseBody
    public float calculChiffreAffaireEntreDeuxDates(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                    @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        return contratService.getChiffreAffaireEntreDeuxDates(startDate, endDate);
    }
}