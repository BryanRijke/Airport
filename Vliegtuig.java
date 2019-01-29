package domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity (name = "VLiegtuig")
public class Vliegtuig {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Registratienummer", updatable = false, nullable = false)
	private int registratieNr;
	
	@ManyToOne
    @JoinColumn (name = "Bedrijfnaam", foreignKey = @ForeignKey (name = "Bedrijf_Bedrijfnaam2"))
    private Bedrijf bedrijfnaam;
	
	@ManyToOne
    @JoinColumn (name = "Modelnummer", foreignKey = @ForeignKey (name = "Vliegtuigtype_Modelnummer1"))
    private Vliegtuigtype modelNr;
	
	@ManyToMany
	@JoinTable (name = "Vliegtuig_Hangar",
		joinColumns = @JoinColumn (name = "Registratienummer", foreignKey = @ForeignKey (name = "Vliegtuig_Registratienummer1")),
		inverseJoinColumns = @JoinColumn (name = "Hangarnummer", foreignKey = @ForeignKey (name = "Hangar_Hangarnummer1")))
	private Set<Hangar> hangars = new HashSet<>();
	
	@ManyToMany
	@JoinTable (name = "Vliegtuig_Piloot",
		joinColumns = @JoinColumn (name = "Registratienummer", foreignKey = @ForeignKey (name = "Vliegtuig_Registratienummer2")),
		inverseJoinColumns = @JoinColumn (name = "Piloot_BSN", foreignKey = @ForeignKey (name = "Piloot_BSN2")))
	private Set<Piloot> piloten = new HashSet<>();
	
	@ManyToMany
	@JoinTable (name = "Onderhoudsbeurt",
		joinColumns = @JoinColumn (name = "Registratienummer", foreignKey = @ForeignKey (name = "Vliegtuig_Registratienummer3")),
		inverseJoinColumns = @JoinColumn (name = "Werknemers_BSN", foreignKey = @ForeignKey (name = "Werknemer_BSN3")))
	private Set<Werknemer> werknemers = new HashSet<>();
	
	
	public Vliegtuig() {
		
	}
	
	public Vliegtuig(int registratieNr) {
		this.registratieNr = registratieNr;
	}

	@Override
	public String toString() {
		return "Vliegtuig: \nRegistratienummer: " + registratieNr;
	}

	public int getRegistratieNr() {
		return registratieNr;
	}

	public void setRegistratieNr(int registratieNr) {
		this.registratieNr = registratieNr;
	}
}