package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcesConsumiUtentePk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "id_aces_consumi_utente")
	private BigInteger idAcesConsumiUtente;

	public AcesConsumiUtentePk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigInteger getIdAcesConsumiUtente() {
		return idAcesConsumiUtente;
	}

	public void setIdAcesConsumiUtente(BigInteger idAcesConsumiUtente) {
		this.idAcesConsumiUtente = idAcesConsumiUtente;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcesConsumiUtentePk)) {
			return false;
		}
		AcesConsumiUtentePk castOther = (AcesConsumiUtentePk)other;
		return 
			(this.idAcesConsumiUtente == castOther.idAcesConsumiUtente)
			;
	}

	public int hashCode() {
		final int prime = 31;
		BigInteger hash = BigInteger.valueOf(17) ;
		hash = hash.multiply(this.idAcesConsumiUtente).add(BigInteger.valueOf(prime));
		
		return hash.intValue();
	}
}
