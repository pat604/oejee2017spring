package com.kota.stratagem.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.protocol.ProjectProtocol;
import com.kota.stratagem.weblayer.common.Page;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = -4363980684441406896L;

	private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);

	private static final String TRUE_VALUE = "1";
	private static final String NEW_PROJECT_ID_FLAG = "-1";

	@EJB
	private ProjectProtocol protocol;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.forward(request, response, false);
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean finishFlag)
			throws ServletException, IOException {
		if(finishFlag) {
			response.sendRedirect(Page.PROJECT_LIST.getUrl());
		} else {
			final RequestDispatcher view = request.getRequestDispatcher(Page.REGISTER.getJspName());
			view.forward(request, response);
		}
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

	}

}

