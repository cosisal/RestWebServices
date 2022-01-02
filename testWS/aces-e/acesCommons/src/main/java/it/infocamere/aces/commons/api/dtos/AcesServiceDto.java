package it.infocamere.aces.commons.api.dtos;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class AcesServiceDto {
	
	BigInteger idAcesService;
	BigInteger fkAcesCpk;
	String serviceName;
	String serviceDescription;
	String userIdInserimento;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class) 
	@JsonDeserialize(using = LocalDateTimeDeserializer.class) 
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)	
	LocalDateTime dtOraInserimento;
	String userIdUltModifica;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
	LocalDateTime dtOraUltModifica;
}
