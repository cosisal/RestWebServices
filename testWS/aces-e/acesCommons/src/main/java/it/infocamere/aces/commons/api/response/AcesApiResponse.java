package it.infocamere.aces.commons.api.response;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import it.infocamere.aces.commons.api.exceptions.AcesApiException;

public class AcesApiResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Status {
		OK, EXCEPTION
	}

	private Status status;
	private AcesApiException exception;
	private T data;

	public AcesApiResponse() {
	}

	public AcesApiResponse(T data) {
		super();
		this.status = Status.OK;
		this.data = data;
	}

	public AcesApiResponse(AcesApiException exception) {
		super();
		this.exception = exception;
		this.status = Status.EXCEPTION;
	}

	public Response toResponse() {
		return Response.ok(this).build();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status statis) {
		this.status = statis;
	}

	public AcesApiException getException() {
		return exception;
	}

	public void setException(AcesApiException exception) {
		this.exception = exception;
	}

	public T getData() {
		return data;
	}

	public AcesApiResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
}
