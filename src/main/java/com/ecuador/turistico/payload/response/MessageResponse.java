package com.ecuador.turistico.payload.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
