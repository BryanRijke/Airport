package domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity (name = "Telefoon")
public class Telefoon {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Telefoonnummer", updatable = false, nullable = false)
	private int telefoonNr;
	
	@ManyToOne
    @JoinColumn (name = "Werknemers_BSN", foreignKey = @ForeignKey (name = "Werknemer_BSN1"))
    private Werknemer w_bsn;
	
	@ManyToOne
    @JoinColumn (name = "Piloot_BSN", foreignKey = @ForeignKey (name = "Piloot_BSN1"))
    private Piloot p_bsn;
	
	@ManyToOne
    @JoinColumn (name = "Bedrijfnaam", foreignKey = @ForeignKey (name = "Bedrijf_Bedrijfnaam1"))
    private Bedrijf bedrijfnaam;
	
	
	public Telefoon() {
		
	}
	
	public Telefoon(int telefoonNr) {
		this.telefoonNr = telefoonNr;
	}

	@Override
	public String toString() {
		return "Telefoon: \nTelefoonnummer: " + telefoonNr;
	}

	public int getTelefoonNr() {
		return telefoonNr;
	}

	public void setTelefoonNr(int telefoonNr) {
		this.telefoonNr = telefoonNr;
	}
}