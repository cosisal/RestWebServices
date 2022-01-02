package it.infocamere.aces.acesJpa.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import it.infocamere.aces.acesJpa.entities.AcesServiceEntity;
import lombok.Data;

@Entity
@Table(name = "aces.aces_service")
@NamedQuery(name = "AcesService.findAll", query = "SELECT a FROM AcesService a")
@Data
//@EqualsAndHashCode(callSuper=false)
public class AcesService extends AcesServiceEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AcesService() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aces_service", nullable = false)	
	private BigInteger idAcesService;
	
	@Column(name = "fk_aces_cpk")
	private BigInteger fkAcesCpk;
	
	@ManyToOne
	@JoinColumn(name = "fk_aces_cpk", updatable = false, insertable = false)
	private AcesCpk acesCpk;
	
	@Column(name = "service_name")
	private String serviceName;
	
	@Column(name = "service_description")
	private String serviceDescription;
	
	@Column(name = "user_id_inserimento")
	private String userIdInserimento;
	
	@Column(name = "dt_ora_inserimento")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dtOraInserimento;
	
	@Column(name = "user_id_ult_modifica")
	private String userIdUltModifica;
	
	@Column(name = "dt_ora_ult_modifica")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dtOraUltModifica;

}
