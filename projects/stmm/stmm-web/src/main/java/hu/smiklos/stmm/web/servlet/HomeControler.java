package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.Page;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@WebServlet("/Home")
public class HomeControler extends HttpServlet {

    @EJB
    private AppUserFacadeInterface facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        AppUserStub user = null;
        try {
            user = facade.getAppUser("2017-02-13-0000001");
        } catch (FacadeException e) {
            e.printStackTrace();
        } catch (PersistenceServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute("user", user);
            request.getRequestDispatcher(Page.HOME.getJspName()).forward(request, response);

    }
}
