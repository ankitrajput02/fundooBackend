package com.bridgelabz.fundoonotesapi.exception;

import javax.naming.AuthenticationException;

public class UserAlreadyPresentException extends AuthenticationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyPresentException(String messageData) {
        super(messageData);
    }

}
