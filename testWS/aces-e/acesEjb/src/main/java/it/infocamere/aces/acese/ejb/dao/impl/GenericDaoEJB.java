package it.infocamere.aces.acese.ejb.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;

import it.infocamere.aces.acesJpa.entities.AcesEntity;

public abstract class GenericDaoEJB<ENT extends AcesEntity> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "ACES_PU")
	protected EntityManager em;

	private Class<ENT> entCls;

	public GenericDaoEJB(Class<ENT> entCls) {
		this.entCls = entCls;
	}

	public ENT find(Object pk) {
		try {
			return em.find(entCls, pk);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void insert(ENT entity) {
		insert(entity, null, null);
	}
	
	public void insert(ENT entity, String user) {
		insert(entity, user, null);
	}

	public void insert(ENT entity, String user, Date date) {
		try {
			try {
				Method setDtOraMethod = getEntCls().getMethod("setDtOraInserimento", Date.class);
				if(date == null){
					setDtOraMethod.invoke(entity, new Date());
				}else{
					setDtOraMethod.invoke(entity, date);
				}
				
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setDtOraInserimento - metodo non trovato nella classe entity");
			}
			try{
				Method setUserIdInsMethod = getEntCls().getMethod("setUseridInserimento", String.class);
				if (StringUtils.isBlank(user)) {
					setUserIdInsMethod.invoke(entity, "INCM-E");
				} else {
					setUserIdInsMethod.invoke(entity, StringUtils.isNotBlank(user) ? user : "");
				}
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setUseridInserimento - metodo non trovato nella classe entity");
			}
			try{
				Method setDtOraUltModMethod = getEntCls().getMethod("setDtOraUltMod", Date.class);
				if(date == null){
					setDtOraUltModMethod.invoke(entity, new Date());
				}else{
					setDtOraUltModMethod.invoke(entity, date);
				}
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setDtOraUltMod - Metodo non trovato nella classe entity");
			}
			try{
				Method setUseridUltModMethod = getEntCls().getMethod("setUserUltMod", String.class);
				if (StringUtils.isBlank(user)) {
					setUseridUltModMethod.invoke(entity, "INCM-E");
				} else {
					setUseridUltModMethod.invoke(entity, user);
				}
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setUserUltMod - metodo non trovato nella classe entity");
			}
		} catch (IllegalArgumentException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		}
		em.detach(entity); // per reinserire le entity cambiando la pk
		em.persist(entity);
		em.flush();
	}

	public void update(ENT entity, String user, Date date) {
		try {
			try {
				Method setDtOraUltModMethod = getEntCls().getMethod("setDtOraUltMod", Date.class);
				if(date == null){
					setDtOraUltModMethod.invoke(entity, new Date());
				}else{
					setDtOraUltModMethod.invoke(entity, date);
				}
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setDtOraUltMod - Metodo non trovato nella classe entity");
			}
			
			try {
				Method setUseridUltModMethod = getEntCls().getMethod("setUserUltMod", String.class);
				if (StringUtils.isBlank(user)) {
					setUseridUltModMethod.invoke(entity, "INCM-E");
				} else {
					setUseridUltModMethod.invoke(entity, user);
				}
			} catch (NoSuchMethodException | SecurityException e1) {
//				IncmeConfig.log(getClass()).warn("setUserUltMod - metodo non trovato nella classe entity");
			}
			
		} catch (IllegalArgumentException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
//			IncmeConfig.log(getClass()).error(e.getMessage(), e);
		}
		em.merge(entity);
		em.flush();
	}

	public void update(ENT entity, String user) {
		update(entity, user, null);
	}
	
	public void update(ENT entity) {
		update(entity, null, null);
	}

	public void delete(ENT entity) {
		em.remove(em.merge(entity));
		em.flush();
	}

	public Class<ENT> getEntCls() {
		return entCls;
	}

	public EntityManager getEntityManager() {
		return em;
	}
	
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}
