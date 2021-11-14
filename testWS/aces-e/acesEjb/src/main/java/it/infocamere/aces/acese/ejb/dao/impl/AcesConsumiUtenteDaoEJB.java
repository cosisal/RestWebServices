package it.infocamere.aces.acese.ejb.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.Stateless;

import it.infocamere.aces.acesJpa.entities.impl.AcesConsumiUtente;
import it.infocamere.aces.acese.ejb.dao.local.AcesConsumiUtenteDaoLocal;

@Stateless
@Local(AcesConsumiUtenteDaoLocal.class)
public class AcesConsumiUtenteDaoEJB implements AcesConsumiUtenteDaoLocal, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public AcesConsumiUtente getConsumiUtente(BigInteger idAcesConsumiUtente) {
		// TODO Auto-generated method stub
		return null;
	}

}
