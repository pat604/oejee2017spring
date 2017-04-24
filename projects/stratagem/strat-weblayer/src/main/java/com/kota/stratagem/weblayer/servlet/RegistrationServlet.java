package com.kota.stratagem.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.protocol.AppUserProtocol;
import com.kota.stratagem.weblayer.common.Page;
import com.kota.stratagem.weblayer.common.RegistrationAttribute;
import com.kota.stratagem.weblayer.common.RegistrationParameter;

@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet implements RegistrationParameter, RegistrationAttribute {

	private static final long serialVersionUID = -4363980684441406896L;

	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

	private static final String TRUE_VALUE = "1";
	private static final String NEW_PROJECT_ID_FLAG = "-1";

	@EJB
	private AppUserProtocol protocol;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppUserRepresentor user = new AppUserRepresentor("", "", "", RoleRepresentor.PRISTINE_USER);
		this.forward(request, response, user, false);
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final AppUserRepresentor user, final boolean finishFlag) throws ServletException, IOException {
		request.setAttribute(ATTR_USER, user);
		if(finishFlag) {
			response.sendRedirect(Page.LOGIN.getUrl());
		} else {
			final RequestDispatcher view = request.getRequestDispatcher(Page.REGISTER.getJspName());
			view.forward(request, response);
		}
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		try {
			final String username = request.getParameter(USERNAME);
			final String email = request.getParameter(EMAIL);
			final String password = request.getParameter(PASSWORD);
			final String password_confirmation = request.getParameter(PASSWORD_CONFIRMATION);
			if(username == null || password == null || password != password_confirmation) {
				LOGGER.info("Registration failed");
				final AppUserRepresentor user = new AppUserRepresentor(username, "", email, RoleRepresentor.PRISTINE_USER);
				this.forward(request, response, user, false);
			} else {
				AppUserRepresentor user = null;
				try {
					LOGGER.info("Registration successful for user: " + username);
					user = this.protocol.saveAppUser(null, username, password, email, RoleRepresentor.PRISTINE_USER, null, null, null, null, null, null, null);
				} catch(final AdaptorException e) {
					LOGGER.error(e, e);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
