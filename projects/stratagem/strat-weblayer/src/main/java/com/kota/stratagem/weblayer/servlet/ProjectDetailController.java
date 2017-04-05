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

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectStatusRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.protocol.ProjectProtocol;
import com.kota.stratagem.weblayer.common.Page;
import com.kota.stratagem.weblayer.common.ProjectAttribute;
import com.kota.stratagem.weblayer.common.ProjectParameter;

@WebServlet("/ProjectDetail")
public class ProjectDetailController extends HttpServlet implements ProjectParameter, ProjectAttribute {

	private static final long serialVersionUID = -8825015852540069920L;

	private static final Logger LOGGER = Logger.getLogger(ProjectDetailController.class);

	private static final String TRUE_VALUE = "1";
	private static final String NEW_PROJECT_ID_FLAG = "-1";

	@EJB
	private ProjectProtocol protocol;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter(ID);
		LOGGER.info("Get Project by id (" + id + ")");
		if(id == null || "".equals(id)) {
			response.sendRedirect(Page.PROJECT_LIST.getUrl());
		} else {
			final boolean editFlag = TRUE_VALUE.equals(request.getParameter(EDIT_FLAG));
			ProjectRepresentor project = null;
			boolean isNew = false;
			if(NEW_PROJECT_ID_FLAG.equals(id)) {
				project = new ProjectRepresentor(-1L, "", ProjectStatusRepresentor.PROPOSED, true);
				isNew = true;
			} else {
				try {
					project = this.protocol.getProject(Long.parseLong(id));
				} catch(final AdaptorException e) {
					LOGGER.error(e, e);
				}
			}
			this.forward(request, response, editFlag, project, isNew);
		}
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean editFlag, final ProjectRepresentor project, boolean isNew)
			throws ServletException, IOException {
		request.setAttribute(ATTR_PROJECT, project);
		request.setAttribute(ATTR_ISNEW, isNew);
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? Page.PROJECT_EDIT.getJspName() : Page.PROJECT_VIEW.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter(ID);
		final String name = request.getParameter(NAME);
		final String description = request.getParameter(DESCRIPTION);
		final ProjectStatusRepresentor status = ProjectStatusRepresentor.valueOf(request.getParameter(STATUS));
		final String visible = request.getParameter(VISIBLE);
		if(ID == null || "".equals(ID)) {
			final ProjectRepresentor project = new ProjectRepresentor(Long.parseLong(id), name, status, Boolean.valueOf(visible));
			this.forward(request, response, true, project, true);
		} else {
			ProjectRepresentor project = null;
			try {
				project = this.protocol.saveProject(Long.parseLong(id), name, description, status, null, Boolean.valueOf(visible));
			} catch(final AdaptorException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, false, project, false);
		}
	}

}
