package it.infocamere.aces.acese.ejb.utils;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import it.infocamere.aces.acese.ejb.dao.impl.AcesCpkDaoEJB;
import it.infocamere.aces.acese.ejb.dao.local.AcesCpkDaoLocal;
import it.infocamere.aces.acese.ejb.exceptions.EjbLookupException;

public class EJBLookup {
	
	private static Map<String, String> ejbMapRemote = new HashMap<String, String>();
	private static Map<String, String> ejbMapLocal = new HashMap<String, String>();
	
	static {
		//mappa ejb per lookup locale
		
		//test EJB
		ejbMapLocal.put(AcesCpkDaoEJB.class.getName(), "java:global/acesEar/acesEjb/AcesCpkDaoEJB!" + AcesCpkDaoLocal.class.getName());	
//		ejbMapLocal.put(RicercaEjbImpl.class.getName(), "java:global/incmEar/incmEjb/RicercaEjbImpl!" + IRicercaEjb.class.getName());
//		ejbMapLocal.put(FornitureSettingEjbImpl.class.getName(), "java:global/incmEar/incmEjb/FornitureSettingEjbImpl!" + IFornitureSettingEjb.class.getName());
		
	}

	private EJBLookup() {

	}

	private static Context getInitialContext(boolean remote) throws NamingException {
		Properties propt = new Properties();
		if (remote) {
			propt.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
			propt.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		} else {
			propt.put(Context.PROVIDER_URL, "localhost");
		}
		return new InitialContext(propt);
	}

	@SuppressWarnings("unchecked")
	public static <S> S lookup(Class<S> cl, String jndiName, boolean remote) throws EjbLookupException {
		Context jndiCtx = null;
		try {
			jndiCtx = getInitialContext(remote);
			Object obj = jndiCtx.lookup(jndiName);
			if (remote) {
				return (S) PortableRemoteObject.narrow(obj, cl);
			} else {
				return (S) obj;
			}
		} catch (Exception e) {
			throw new EjbLookupException("Errore lookup EJB", e);
		}
	}

	public static <S> S lookup(Class<S> cl, boolean remote) throws EjbLookupException {
		S ref = null;
		try {
			String jndiName;
			if (remote) {
				jndiName = ejbMapRemote.get(cl.getName());
			} else {
				jndiName = ejbMapLocal.get(cl.getName());
			}
			if (jndiName != null) {
				ref = lookup(cl, jndiName, remote);
			} else {
				throw new EjbLookupException("Nessun jndi-name trovato in configurazione per la classe " + cl.getSimpleName());
			}
		} catch (Exception e) {
			throw new EjbLookupException("Errore lookup EJB", e);
		}
		return ref;
	}

	public static <S> S lookup(Class<S> cl, boolean remote, S current) throws EjbLookupException {
		if (current == null) {
			return lookup(cl, remote);
		} else {
			return current;
		}
	}
	
	public static <S> S lookupLocal(Class<S> cl) throws EjbLookupException {
		return lookup(cl, false);
	}
}