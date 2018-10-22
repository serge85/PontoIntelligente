package com.kazale.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	/**
	 * Generate Hash using BCrypt
	 * 
	 * @param password
	 * @return String
	 */
	public static String gerarBCrypt(String password) {
		if( password == null )
			return password;
		
		log.info("Generating Hash with BCript. ");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(password);
	}

}
