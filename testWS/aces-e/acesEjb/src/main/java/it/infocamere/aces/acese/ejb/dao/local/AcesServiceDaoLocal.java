package it.infocamere.aces.acese.ejb.dao.local;

import javax.ejb.Local;
import javax.ejb.Remote;

import it.infocamere.aces.acese.ejb.dao.AcesServiceDao;

@Local
@Remote
public interface AcesServiceDaoLocal extends AcesServiceDao{

}
