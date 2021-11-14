package it.infocamere.aces.acesJpa.entities.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.infocamere.aces.acesJpa.entities.AcesConsumiUtenteEntity;
import lombok.Data;

@Entity
@Table(name = "aces_consumi_utente")
@NamedQuery(name = "AcesConsumiUtente.findAll", query = "SELECT a FROM AcesConsumiUtente a")
@Data
public class AcesConsumiUtente extends AcesConsumiUtenteEntity {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcesConsumiUtentePk id;

	@Column(name = "fk_aces_user_service")
	private String fkAcesUserSerService;

	@Column(name = "codice_scheda_accounting")
	private String codiceSchedaAccounting;
	
	@Column(name = "cardinality")
	private int cardinality;

	@Column(name = "userid_inserimento")
	private String useridInserimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_ora_inserimento")
	private Date dtOraInserimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_ora_ult_modifica")
	private Date dtOraUltModifica;

	@Column(name = "user_ult_modifica")
	private String userUltMod;

}
