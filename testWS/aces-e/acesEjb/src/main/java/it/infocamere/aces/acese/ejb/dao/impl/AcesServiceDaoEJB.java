package it.infocamere.aces.acese.ejb.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.infocamere.aces.acesJpa.entities.impl.AcesService;
import it.infocamere.aces.acese.ejb.dao.local.AcesServiceDaoLocal;
import it.infocamere.aces.acese.ejb.dao.remote.AcesServiceDaoRemote;
import it.infocamere.aces.commons.api.dtos.AcesServiceDto;
import it.infocamere.aces.commons.api.dtos.AcesServiceListDto;

@Stateless(mappedName = "AcesServiceDaoEJB", name = "AcesServiceDaoEJB")
@Local(AcesServiceDaoLocal.class)
@Remote(AcesServiceDaoRemote.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AcesServiceDaoEJB
//		extends GenericDaoEJB<AcesCpk> 
		implements AcesServiceDaoLocal, AcesServiceDaoRemote {

//	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ACES_PU")
	protected EntityManager em;

	@Override
	public AcesServiceDto insertAcesService(AcesServiceDto acesServiceDto) {
		
		AcesService acesService = new AcesService();
		
		if (acesServiceDto != null) {
			
			acesService.setFkAcesCpk(acesServiceDto.getFkAcesCpk());
			acesService.setServiceName(acesServiceDto.getServiceName());
			acesService.setServiceDescription(acesServiceDto.getServiceDescription());
			acesService.setDtOraInserimento(LocalDateTime.now());
			acesService.setDtOraUltModifica(LocalDateTime.now());
			acesService.setUserIdInserimento("ACES-E");
			acesService.setUserIdUltModifica("ACES-E");
		}
		
		this.em.persist(acesService);
		this.em.flush();
				
		return acesServiceDto;
	}

	@Override
	public AcesServiceListDto getAcesServiceList() {
		AcesServiceListDto acesServiceListDto = new AcesServiceListDto();
		System.out.println("Sono nell'implementazione dell'EJB");

		List<AcesServiceDto> acesServiceList = acesServiceListDto.getAcesServiceList();

		TypedQuery<AcesService> tQuery = this.em.createQuery("from AcesService", AcesService.class);
		List<AcesService> resultList = tQuery.getResultList();

		for (AcesService acesService : resultList) {
			AcesServiceDto acesServiceDto = new AcesServiceDto();
			
			acesServiceDto.setIdAcesService(acesService.getIdAcesService());
			acesServiceDto.setFkAcesCpk(acesService.getAcesCpk().getIdAcesCpk());
			acesServiceDto.setServiceName(acesService.getServiceName());
			acesServiceDto.setServiceDescription(acesService.getServiceDescription());
			acesServiceDto.setUserIdInserimento(acesService.getUserIdInserimento());
			acesServiceDto.setDtOraInserimento(acesService.getDtOraInserimento());
			acesServiceDto.setUserIdUltModifica(acesService.getUserIdUltModifica());
			acesServiceDto.setDtOraUltModifica(acesService.getDtOraUltModifica());
			acesServiceList.add(acesServiceDto);
		}

		return acesServiceListDto;
	}

}
