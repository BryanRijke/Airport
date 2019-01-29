package domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;;

@Entity (name = "Hangar")
public class Hangar {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Hangarnummer", updatable = false, nullable = false)
	private int hangarNr;
	
	@Column (name = "Hangar_oppervlakte")
	private int hangarOpp;
	
	@ManyToMany (mappedBy = "hangars")
	private Set<Vliegtuig> vliegtuigen = new HashSet<>();
	
	
	
	public Hangar() {
		
	}
	
	public Hangar(int hangarNr, int hangarOpp) {
		this.hangarNr = hangarNr;
		this.hangarOpp = hangarOpp;
	}

	@Override
	public String toString() {
		return "Hangar: \nHangarnummer: " + hangarNr + "\nHangaroppervlakte: " + hangarOpp;
	}

	public int getHangarNr() {
		return hangarNr;
	}

	public void setHangarNr(int hangarNr) {
		this.hangarNr = hangarNr;
	}

	public int getHangarOpp() {
		return hangarOpp;
	}

	public void setHangarOpp(int hangarOpp) {
		this.hangarOpp = hangarOpp;
	}
}