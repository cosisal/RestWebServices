package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import it.infocamere.aces.acesJpa.entities.AcesCpkEntity;
import lombok.Data;

@Entity
@Table(name = "aces.aces_cpk")
@NamedQuery(name = "AcesCpk.findAll", query = "SELECT a FROM AcesCpk a")
@Data
//@EqualsAndHashCode(callSuper=false)
public class AcesCpk extends AcesCpkEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
//	@EmbeddedId
//	private AcesCpkPk idAcesCpkPk;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aces_cpk", nullable = false)	
	private BigInteger idAcesCpk;
	
	@Column(name = "cdp")
	private String cdp;
	
	@Column(name = "cpk")
	private String cpk;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "user_id_inserimento")
	private String userIdInserimento;
	
	@Column(name = "dt_ora_ult_modifica")
	private Date dtOraUltModifica;

	@Column(name = "dt_ora_inserimento")
	private Date dtOraInserimento;
	
	@Column(name = "user_id_ult_modifica")
	private String userIdUltModifica;

}
