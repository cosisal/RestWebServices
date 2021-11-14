package it.infocamere.aces.acese.ejb.dao.impl;

import java.util.List;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

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
public class AcesCpkDaoEJB extends GenericDaoEJB<AcesCpk> implements AcesCpkDaoLocal, AcesCpkDaoRemote {

//	private static final long serialVersionUID = 1L;

	public AcesCpkDaoEJB(Class<AcesCpk> entCls) {
		super(entCls);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CpkListDto getCpkList() {
		
		CpkListDto cpkListDto = new CpkListDto();	
		System.out.println("Sono nell'implementazione dell'EJB");
//		ArrayList<AcesCpk> cpkList = new ArrayList<AcesCpk>();
		
		Cpk cpk = new Cpk();
		
		cpk.setCdp("PROVA");
		
		cpkListDto.getCpkList().add(cpk);
		
//		Query query = this.getEntityManager().createNativeQuery("Select * from aces.aces_cpk");
//		List resultList = query.getResultList();
		return cpkListDto;
	}
	
	
	
}
