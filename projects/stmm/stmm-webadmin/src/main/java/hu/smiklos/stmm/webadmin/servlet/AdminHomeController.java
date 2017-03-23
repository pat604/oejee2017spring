package hu.smiklos.stmm.webadmin.servlet;


import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.ejb.parameternames.web.WebParameterName;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.webadmin.common.AdminActions;
import hu.smiklos.stmm.webadmin.common.AdminPages;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@WebServlet("/AdminHome")
public class AdminHomeController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private AdminActions action;

    @EJB
    private AppUserFacadeInterface facade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        this.request = request;
        this.response = response;
        //this.action = AdminActions.ListUserAction.getAction(request.getParameter(WebParameterName.Action.getName()));
        this.handleGet();

    }

    private void handleGet() throws ServletException, IOException {

        if(this.action != null) {
            switch (this.action) {
                case ListUserAction:
                    this.request.getRequestDispatcher(AdminPages.AppUsers.getJspName()).forward(this.request, this.response);
                    break;
                default:
                    this.request.getRequestDispatcher(AdminPages.AdminHome.getJspName()).forward(this.request, this.response);
            }
        }else {
            this.request.getRequestDispatcher(AdminPages.AdminHome.getJspName()).forward(this.request, this.response);
        }
    }


}
