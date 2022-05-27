package com.ecuador.turistico.payload.response;

import java.util.List;

import lombok.Data;


@Data
public class MessageResponse {
	
	
	private String message;
	
	private List<SolResponse> respuestaSol;
	

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public MessageResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
