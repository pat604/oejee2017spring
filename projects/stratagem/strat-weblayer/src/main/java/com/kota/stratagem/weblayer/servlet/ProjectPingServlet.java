package com.kota.stratagem.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.protocol.ProjectProtocol;

@WebServlet("/ProjectPing")
public class ProjectPingServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8846054069350402208L;
	
	private static final Logger LOGGER = Logger.getLogger(ProjectPingServlet.class);

	@EJB
	private ProjectProtocol protocol;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Student by user");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final List<ProjectRepresentor> projects = this.protocol.getAllProjects();
			for (ProjectRepresentor representor : projects) {
				out.println(representor.toString());
			}
		} catch (final Exception e) {
			LOGGER.error(e, e);
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}
	
}