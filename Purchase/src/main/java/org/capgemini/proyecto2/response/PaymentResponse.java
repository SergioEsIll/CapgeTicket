package org.capgemini.proyecto2.response;

import java.io.Serializable;
import java.util.List;

public class PaymentResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String timestamp;
	private String status;
	private String error;
	private List<String> message;
	private String infoAdicional;

	public PaymentResponse() {
		super();
	}

	public PaymentResponse(String timestamp, String status, String error, List<String> message, String infoAdicional) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.infoAdicional = infoAdicional;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PaymentResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", infoAdicional=" + infoAdicional + "]";
	}

}