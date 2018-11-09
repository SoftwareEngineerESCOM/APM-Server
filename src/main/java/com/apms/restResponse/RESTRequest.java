package com.apms.restResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RESTRequest<T> {
	private String token;
	private T payload;

	public RESTRequest(String token, T payload) {
		this.token = token;
		this.payload = payload;
	}

}
