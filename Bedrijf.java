package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "Bedrijf")
public class Bedrijf {
	
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Bedrijfnaam", updatable = false, nullable = false)
	private String bedrijfnaam;
	
	@Column (name = "Adres")
	private String adres;
	
	@OneToMany(mappedBy = "bedrijfnaam")
    private List<Telefoon> telefoons = new ArrayList<Telefoon>();
	
	@OneToMany(mappedBy = "bedrijfnaam")
    private List<Vliegtuig> vliegtuigen = new ArrayList<Vliegtuig>();
	
	
	public Bedrijf() {
		
	}
	
	public Bedrijf(String bedrijfnaam, String adres) {
		this.bedrijfnaam = bedrijfnaam;
		this.adres = adres;
	}
	
	@Override
	public String toString() {
		return "Bedrijf: \nNaam: " + bedrijfnaam + "\nAdres: " + adres;
	}

	public String getBedrijfnaam() {
		return bedrijfnaam;
	}

	public void setBedrijfnaam(String bedrijfnaam) {
		this.bedrijfnaam = bedrijfnaam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
}