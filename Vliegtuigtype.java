package domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity (name = "VLiegtuigtype")
public class Vliegtuigtype {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Modelnummer", updatable = false, nullable = false)
	private int modelNr;
	
	@Column (name = "Capaciteit")
	private int capaciteit;
	
	@Column (name = "Gewicht")
	private int gewicht;
	
	@OneToMany(mappedBy = "modelNr")
    private List<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
	
	@ManyToMany(mappedBy = "vliegtuigtypes")
    private Set<Werknemer> werknemers = new HashSet<>();
	
	
	public Vliegtuigtype() {
		
	}
	
	public Vliegtuigtype(int modelNr, int capaciteit, int gewicht) {
		this.modelNr = modelNr;
		this.capaciteit = capaciteit;
		this.gewicht = gewicht;
	}

	@Override
	public String toString() {
		return "Vliegtuigtype: \nModelnummer: " + modelNr + "\nCapaciteit: " + capaciteit + "\nGewicht: " + gewicht;
	}

	public int getModelNr() {
		return modelNr;
	}

	public void setModelNr(int modelNr) {
		this.modelNr = modelNr;
	}

	public int getCapaciteit() {
		return capaciteit;
	}

	public void setCapaciteit(int capaciteit) {
		this.capaciteit = capaciteit;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
}