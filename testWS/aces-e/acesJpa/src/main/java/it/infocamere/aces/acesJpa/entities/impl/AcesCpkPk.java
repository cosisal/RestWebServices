package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcesCpkPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_aces_cpk")
	private BigInteger idAcesCpk;
	
	public AcesCpkPk() {
		super();
	}

	public BigInteger getIdAcesCpk() {
		return idAcesCpk;
	}

	public void setIdAcesCpk(BigInteger idAcesCpk) {
		this.idAcesCpk = idAcesCpk;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcesCpkPk)) {
			return false;
		}
		AcesCpkPk castOther = (AcesCpkPk)other;
		return 
			(this.idAcesCpk == castOther.idAcesCpk)
			;
	}

	public int hashCode() {
		final int prime = 31;
		BigInteger hash = BigInteger.valueOf(17) ;
		hash = hash.multiply(this.idAcesCpk).add(BigInteger.valueOf(prime));
		
		return hash.intValue();
	}
	
}
