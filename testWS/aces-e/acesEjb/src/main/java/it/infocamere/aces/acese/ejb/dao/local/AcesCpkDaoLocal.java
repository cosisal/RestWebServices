package it.infocamere.aces.acese.ejb.dao.local;

import javax.ejb.Local;
import javax.ejb.Remote;

import it.infocamere.aces.acese.ejb.dao.AcesCpkDao;

@Local
@Remote
public interface AcesCpkDaoLocal extends AcesCpkDao{

}
