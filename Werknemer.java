package domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;

@Entity (name = "Werknemer")
public class Werknemer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Werknemers_BSN", updatable = false, nullable = false)
	private int w_bsn;
	
	@Column (name = "Achternaam")
	private String naam;
	
	@Column (name = "Voornaam")
	private String voornaam;
	
	@Column (name = "Adres")
	private String adres;
	
	@Column (name = "Salaris")
	private int salaris;
	
	@Column (name = "Shift")
	private String shift;
	
	@OneToMany(mappedBy = "w_bsn")
    private List<Telefoon> telefoons = new ArrayList<Telefoon>();
	
	@ManyToMany
	@JoinTable (name = "VLiegtuigtype_Werknemer",
		joinColumns = @JoinColumn (name = "Werknemers_BSN", foreignKey = @ForeignKey (name = "Werknemer_BSN2")),
		inverseJoinColumns = @JoinColumn (name = "Modelnummer", foreignKey = @ForeignKey (name = "Vliegtuigtype_Modelnummer2")))
	private Set<Vliegtuigtype> vliegtuigtypes = new HashSet<>();
	
	@ManyToMany (mappedBy = "werknemers")
    private Set<Vliegtuig> vliegtuigen = new HashSet<>();
	
	
	public Werknemer() {
		
	}
	
	public Werknemer(int w_bsn, String naam, String voornaam, String adres, int salaris, String shift) {
		this.w_bsn = w_bsn;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.salaris = salaris;
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Werknemer: \nBSN: " + w_bsn + "\nNaam: " + naam + "\nVoornaam: " + voornaam + "\nAdres: " + adres + "\nSalaris: "
				+ salaris + "\nShift: " + shift;
	}

	public int getW_bsn() {
		return w_bsn;
	}

	public void setW_bsn(int w_bsn) {
		this.w_bsn = w_bsn;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getSalaris() {
		return salaris;
	}

	public void setSalaris(int salaris) {
		this.salaris = salaris;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
}