package com.test.bankingPrototype.exceptions;

import java.time.LocalDateTime;

public class AuthException extends Exception {

	public AuthException(String errorMessage, String errorCode) {
		setErrorMessage(errorMessage);
		setErrorCode(errorCode);
		setTimestamp(LocalDateTime.now());
	}
}
