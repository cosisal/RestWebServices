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

		List<Cpk> cpkList = cpkListDto.getCpkList();

		TypedQuery<AcesCpk> tQuery = this.em.createQuery("from AcesCpk", AcesCpk.class);
		List<AcesCpk> resultList = tQuery.getResultList();

		for (AcesCpk acesCpk : resultList) {
			Cpk cpk = new Cpk();
//			cpk.setIdAcesCpk(acesCpk.getIdAcesCpkPk().getIdAcesCpk());
			cpk.setIdAcesCpk(acesCpk.getIdAcesCpk());
			cpk.setCdp(acesCpk.getCdp());
			cpk.setCpk(acesCpk.getCpk());
			cpk.setDescription(acesCpk.getDescription());
			cpk.setUserIdInserimento(acesCpk.getUserIdInserimento());
			cpk.setDtOraInserimento(acesCpk.getDtOraInserimento());
			cpk.setUserIdUltModifica(acesCpk.getUserIdUltModifica());
			cpk.setDtOraUltModifica(acesCpk.getDtOraUltModifica());
			cpkList.add(cpk);
		}

		// TODO: fare il cast del risultato della query in AcesCpkDao

		return cpkListDto;
	}

	@Override
	public Cpk insertCpk(Cpk cpk) {
		
		AcesCpk acesCpk = new AcesCpk();
		
		if (cpk != null) {
			
			acesCpk.setCdp(cpk.getCdp());
			acesCpk.setCpk(cpk.getCpk());
			acesCpk.setDescription(cpk.getDescription());
			acesCpk.setDtOraInserimento(new Date());
			acesCpk.setDtOraUltModifica(new Date());
			acesCpk.setUserIdInserimento("ACES-E");
			acesCpk.setUserIdUltModifica("ACES-E");
		}
		
//		EntityTransaction transaction = this.em.getTransaction();
//		transaction.begin();
		this.em.persist(acesCpk);
		this.em.flush();
//		transaction.commit();
				
		return cpk;
	}

}
