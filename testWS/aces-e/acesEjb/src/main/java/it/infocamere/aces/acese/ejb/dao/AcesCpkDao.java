package it.infocamere.aces.acese.ejb.dao;

import it.infocamere.aces.commons.api.dtos.Cpk;
import it.infocamere.aces.commons.api.dtos.CpkListDto;

public interface AcesCpkDao {
	CpkListDto getCpkList();
	Cpk insertCpk(Cpk cpk);
}
