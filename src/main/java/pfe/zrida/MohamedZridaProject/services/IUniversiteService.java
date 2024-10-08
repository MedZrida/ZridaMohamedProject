package pfe.zrida.MohamedZridaProject.services;

import pfe.zrida.MohamedZridaProject.entities.Departement;
import pfe.zrida.MohamedZridaProject.entities.Universite;

import java.util.List;
import java.util.Set;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite  u);

    Universite updateUniversite (Universite  u);

    Universite retrieveUniversite (Integer idUniversite);

    public  void deleteUniversite(Integer idUniversite);

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
