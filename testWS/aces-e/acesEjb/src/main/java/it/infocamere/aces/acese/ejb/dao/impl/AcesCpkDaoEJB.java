package it.infocamere.aces.acese.ejb.dao.impl;

import java.util.Date;
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

import it.infocamere.aces.acesJpa.entities.impl.AcesCpk;
import it.infocamere.aces.acese.ejb.dao.local.AcesCpkDaoLocal;
import it.infocamere.aces.acese.ejb.dao.remote.AcesCpkDaoRemote;
import it.infocamere.aces.commons.api.dtos.Cpk;
import it.infocamere.aces.commons.api.dtos.CpkListDto;

@Stateless(mappedName = "AcesCpkDaoEJB", name = "AcesCpkDaoEJB")
@Local(AcesCpkDaoLocal.class)
@Remote(AcesCpkDaoRemote.class)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AcesCpkDaoEJB
//		extends GenericDaoEJB<AcesCpk> 
		implements AcesCpkDaoLocal, AcesCpkDaoRemote {

//	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "ACES_PU")
	protected EntityManager em;
	
//	public AcesCpkDaoEJB(Class<AcesCpk> entCls) {
//		super(entCls);
//	}

	@Override
	public CpkListDto getCpkList() {

		CpkListDto cpkListDto = new CpkListDto();
		System.out.println("Sono nell'implementazione dell'EJB");
//		ArrayList<AcesCpk> cpkList = new ArrayList<AcesCpk>();

//		cpkListDto.getCpkList().add(cpk);
		List<Cpk> cpkList = cpkListDto.getCpkList();
		
		TypedQuery<AcesCpk> tQuery = this.em.createQuery("from AcesCpk", AcesCpk.class);
		List<AcesCpk> resultList = tQuery.getResultList();
		
		
		for (AcesCpk acesCpk : resultList) {
			Cpk cpk = new Cpk();
			cpk.setIdAcesCpk(acesCpk.getIdAcesCpkPk().getIdAcesCpk());
			cpk.setCdp(acesCpk.getCdp());
			cpk.setCpk(acesCpk.getCpk());
			cpk.setDescription(acesCpk.getDescription());
			cpk.setUserIdInserimento("ACES-E");
			cpk.setDtOraInserimento(new Date());
			cpk.setUserIdUltModifica("ACES-E");
			cpk.setDtOraUltModifica(new Date());
			cpkList.add(cpk);
		}
//		Query query = this.em.createNativeQuery("Select * from aces.aces_cpk");
//		
//		List resultList = query.getResultList();
//		
//		TODO: fare il cast del risultato della query in AcesCpkDao
		
		return cpkListDto;
	}

}
