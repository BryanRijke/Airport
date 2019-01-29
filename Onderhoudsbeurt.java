package domain.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Onderhoudsbeurt")
public class Onderhoudsbeurt {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Raportnummer", updatable = false, nullable = false)
	private int raportNr;
	
	@Column (name = "Datum_van_onderhoud")
	@Temporal (TemporalType.DATE)
	private Calendar datumOnderhoud;
	
	@Column (name = "Type_werk")
	private String typeWerk;
	
	public Onderhoudsbeurt() {
		
	}
	
	public Onderhoudsbeurt(int raportNr, Calendar datumOnderhoud, String typeWerk) {
		this.raportNr = raportNr;
		this.datumOnderhoud = datumOnderhoud;
		this.typeWerk = typeWerk;
	}

	@Override
	public String toString() {
		return "Onderhoudsbeurt: \nRaportnummer: " + raportNr + "\nDatum van onderhoud: " + datumOnderhoud + "\nType werk: " + typeWerk;
	}

	public int getRaportNr() {
		return raportNr;
	}

	public void setRaportNr(int raportNr) {
		this.raportNr = raportNr;
	}

	public Calendar getDatumOnderhoud() {
		return datumOnderhoud;
	}

	public void setDatumOnderhoud(Calendar datumOnderhoud) {
		this.datumOnderhoud = datumOnderhoud;
	}

	public String getTypeWerk() {
		return typeWerk;
	}

	public void setTypeWerk(String typeWerk) {
		this.typeWerk = typeWerk;
	}
}