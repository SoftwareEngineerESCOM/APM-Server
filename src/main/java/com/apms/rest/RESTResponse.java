package com.apms.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RESTResponse<T> {
	private Integer code;
	private String message;
	private T payload;
	public static int OK = 200;
	public static int FAIL = 500;
	public static int DBFAIL = 501;

	public RESTResponse(Integer code, String message, T payload) {
		this.code = code;
		this.message = message;
		this.payload = payload;
	}

}
