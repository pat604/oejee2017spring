package com.kota.stratagem.security.authenticity;

import javax.ejb.EJB;

import org.jboss.security.auth.spi.DatabaseServerLoginModule;

import com.kota.stratagem.security.encryption.PasswordCorrelationService;

public class LoginModule extends DatabaseServerLoginModule {

	@EJB
	private PasswordCorrelationService passwordService;

	@Override
	protected boolean validatePassword(String inputPassword, String expectedPassword) {
		return passwordService.BCryptCorrelation(inputPassword, expectedPassword);
	}

}