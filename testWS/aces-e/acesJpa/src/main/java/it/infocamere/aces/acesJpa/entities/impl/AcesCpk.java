package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dtOraUltModifica;

	@Column(name = "dt_ora_inserimento")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dtOraInserimento;
	
	@Column(name = "user_id_ult_modifica")
	private String userIdUltModifica;

}
