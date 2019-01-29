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

@Entity (name = "Piloot")
public class Piloot {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Piloot_BSN", updatable = false, nullable = false)
	private int p_bsn;
	
	@Column (name = "VLiegtuigtype")
	private String vliegtuigType;
	
	@Column (name = "Achternaam")
	private String naam;
	
	@Column (name = "Voornaam")
	private String voornaam;
	
	@Column (name = "Adres")
	private String adres;
	
	@Column (name = "Licentienummer")
	private int licentieNr;
	
	@Column (name = "Beperkingen")
	private String beperkingen;
	
	@OneToMany(mappedBy = "p_bsn")
    private List<Telefoon> telefoons = new ArrayList<Telefoon>();
	
	@ManyToMany (mappedBy = "piloten")
    private Set<Vliegtuig> vliegtuigen = new HashSet<>();
	
	
	public Piloot() {
		
	}
	
	public Piloot(int p_bsn, String vliegtuigType, String naam, String voornaam, String adres, int licentieNr, String beperkingen) {
		this.p_bsn = p_bsn;
		this.vliegtuigType = vliegtuigType;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.licentieNr = licentieNr;
		this.beperkingen = beperkingen;
	}

	@Override
	public String toString() {
		return "Piloot: \nBSN: " + p_bsn + "\nVliegtuigyype: " + vliegtuigType + "\nNaam: " + naam + "\nVoornaam: " + voornaam
				+ "\nAdres: " + adres + "\nLicentienummer: " + licentieNr + "\nBeperkingen: " + beperkingen;
	}

	public int getP_bsn() {
		return p_bsn;
	}

	public void setP_bsn(int p_bsn) {
		this.p_bsn = p_bsn;
	}

	public String getVliegtuigType() {
		return vliegtuigType;
	}

	public void setVliegtuigType(String vliegtuigType) {
		this.vliegtuigType = vliegtuigType;
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

	public int getLicentieNr() {
		return licentieNr;
	}

	public void setLicentieNr(int licentieNr) {
		this.licentieNr = licentieNr;
	}

	public String getBeperkingen() {
		return beperkingen;
	}

	public void setBeperkingen(String beperkingen) {
		this.beperkingen = beperkingen;
	}
}