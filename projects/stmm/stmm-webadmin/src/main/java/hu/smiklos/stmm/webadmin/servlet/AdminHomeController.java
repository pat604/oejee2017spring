package hu.smiklos.stmm.webadmin.servlet;


import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
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

    @EJB
    private AppUserFacadeInterface facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        AppUserStub user = null;
        final PrintWriter out = response.getWriter();
        try {
            user = facade.getAppUser("2017-02-13-0000001");
            out.println(user.toString());
        } catch (FacadeException e) {
            e.printStackTrace();
            out.println(e.getLocalizedMessage());
        } catch (PersistenceServiceException e) {
            e.printStackTrace();
        }

        //request.setAttribute("user", user);
        request.getRequestDispatcher(AdminPages.AdminHome.getJspName()).forward(request, response);

    }
}
