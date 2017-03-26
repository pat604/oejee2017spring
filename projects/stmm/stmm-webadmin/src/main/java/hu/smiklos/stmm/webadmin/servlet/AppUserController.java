package hu.smiklos.stmm.webadmin.servlet;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.ejb.parameternames.web.WebParameterName;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.webadmin.common.AdminActions;
import hu.smiklos.stmm.webadmin.common.AdminPages;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 20..
 */
@WebServlet("/AppUser")
public class AppUserController extends HttpServlet {
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
        this.action = AdminActions.getAction(request.getParameter(WebParameterName.Action.getName()));
        try {
            this.handleGet();
        } catch (FacadeException e) {
            e.printStackTrace();
        } catch (PersistenceServiceException e) {
            e.printStackTrace();
        }

    }

    private void handleGet() throws ServletException, IOException, FacadeException, PersistenceServiceException {
        switch(this.action){
            case ListUserAction:
                ListUsersAction();
                break;
            case EditUser:
                EditUserAction();
                break;
            default:
                DefaultAction();
                //this.request.getRequestDispatcher(AdminPages.AppUsers.getJspName()).forward(this.request, this.response);
        }
    }

    private void EditUserAction() throws ServletException, IOException, PersistenceServiceException, FacadeException {
        String id = request.getParameter(AppUserParameter.ID);
        AppUserStub user = facade.getAppUser(id);
        //request.setAttribute("users", users);
        this.request.getRequestDispatcher(AdminPages.EditUser.getJspName()).forward(request, response);
    }

    private void DefaultAction() throws FacadeException, PersistenceServiceException, ServletException, IOException {
        ListUsersAction();
    }

    private void ListUsersAction() throws ServletException, IOException, PersistenceServiceException, FacadeException {
        List<AppUserStub> users = facade.getAllAppUser();
        request.setAttribute("users", users);
        this.request.getRequestDispatcher(AdminPages.AppUsers.getJspName()).forward(request, response);
    }
}

