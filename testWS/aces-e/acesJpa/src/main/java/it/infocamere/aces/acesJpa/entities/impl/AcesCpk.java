package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import it.infocamere.aces.acesJpa.entities.AcesEntity;
import lombok.Data;

@Entity
@Table(name = "aces_cpk")
@NamedQuery(name = "AcesCpk.findAll", query = "SELECT a FROM AcesCpk a")
@Data
public class AcesCpk extends AcesEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AcesCpkPk idAcesCpkPk;
	
	@Column(name = "cdp")
	private String cdp;
	
	@Column(name = "cpk")
	private String cpk;
	
	@Column(name = "user_id_inserimento")
	private String userIdInserimento;
	
	@Column(name = "dt_ora_ult_modifica")
	private Date dtOraUltModifica;

	@Column(name = "dt_ora_inserimento")
	private Date dtOraInserimento;
	
	@Column(name = "user_id_ult_modifica")
	private String userIdUltModifica;

}
