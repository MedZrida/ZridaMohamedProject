package pfe.zrida.MohamedZridaProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUniv;
    private String nomUniv;
    private String model;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Departement> departements = new HashSet<>();

    public Universite() {
        // Initialize the departements collection
        this.departements = new HashSet<>();
    }

    public Universite(String nomUniv) {
        super();
        this.nomUniv = nomUniv;
        this.departements = new HashSet<>();
    }

    public Universite(Integer idUniv, String nomUniv) {
        super();
        this.idUniv = idUniv;
        this.nomUniv = nomUniv;
        this.departements = new HashSet<>();
    }
}
