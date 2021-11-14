package it.infocamere.aces.commons.api.dtos;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class Cpk {
	BigInteger idAcesCpk;
	String cdp;
	String cpk;
	String description;
	String userIdInserimento;
	Date dtOraInserimento;
	String userIdUltModifica;
	Date dtOraUltModifica;
}
