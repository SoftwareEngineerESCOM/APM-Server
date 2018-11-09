package com.apms.restResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RESTResponse<T> {
	private Integer code;
	private String message;
	private T payload;

	public RESTResponse(Integer code, String message, T payload) {
		this.code = code;
		this.message = message;
		this.payload = payload;
	}

}
