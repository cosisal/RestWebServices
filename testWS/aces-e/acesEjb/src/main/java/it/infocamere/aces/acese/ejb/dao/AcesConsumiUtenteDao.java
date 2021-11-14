package it.infocamere.aces.acese.ejb.dao;

import java.math.BigInteger;

import it.infocamere.aces.acesJpa.entities.impl.AcesConsumiUtente;

public interface AcesConsumiUtenteDao {
	
	AcesConsumiUtente getConsumiUtente(BigInteger idAcesConsumiUtente);
	
}
