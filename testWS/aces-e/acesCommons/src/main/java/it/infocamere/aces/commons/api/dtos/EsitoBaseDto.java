package it.infocamere.aces.commons.api.dtos;

import java.io.Serializable;

public class EsitoBaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean esito;
	private String codiceErrore;
	private String descrizioneErrore;

	public EsitoBaseDto() {
		super();
	}

	public EsitoBaseDto(boolean esito) {
		super();
		this.esito = esito;
	}

	public EsitoBaseDto(boolean esito, String codiceErrore, String descrizioneErrore) {
		super();
		this.esito = esito;
		this.codiceErrore = codiceErrore;
		this.descrizioneErrore = descrizioneErrore;
	}

	public boolean isEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		this.esito = esito;
	}

	public String getCodiceErrore() {
		return codiceErrore;
	}

	public void setCodiceErrore(String codiceErrore) {
		this.codiceErrore = codiceErrore;
	}

	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}

	@Override
	public String toString() {
		return "EsitoInvioDto [esito=" + esito + ", codiceErrore=" + codiceErrore + ", descrizioneErrore="
				+ descrizioneErrore + "]";
	}

}
