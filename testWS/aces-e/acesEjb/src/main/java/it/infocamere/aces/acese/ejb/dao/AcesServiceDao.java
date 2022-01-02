package it.infocamere.aces.acese.ejb.dao;

import it.infocamere.aces.commons.api.dtos.AcesServiceDto;
import it.infocamere.aces.commons.api.dtos.AcesServiceListDto;

public interface AcesServiceDao {
	AcesServiceListDto getAcesServiceList();
	AcesServiceDto insertAcesService(AcesServiceDto cpk);
}
