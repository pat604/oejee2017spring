package hu.smiklos.stmm.webadmin.servlet;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.ejb.facade.UserTypeFacadeInterface;
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
import java.util.List;

import static hu.smiklos.stmm.webadmin.common.AdminActions.EditUser;
import static hu.smiklos.stmm.webadmin.common.AdminActions.ListUserAction;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
@WebServlet("/UserType")
public class UserTypeController extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private AdminActions action;

    @EJB
    private UserTypeFacadeInterface facade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case ListUserTypesAction:
                ListUserTypesAction();
                break;
            default:
                DefaultAction();
                //this.request.getRequestDispatcher(AdminPages.AppUsers.getJspName()).forward(this.request, this.response);
        }
    }

    private void DefaultAction() throws ServletException, IOException, PersistenceServiceException {
        ListUserTypesAction();
    }

    private void ListUserTypesAction() throws PersistenceServiceException, ServletException, IOException {
        List<UserTypeStub> userTypeList = facade.getAllUserType();
        request.setAttribute("usertypelist", userTypeList);
        this.request.getRequestDispatcher(AdminPages.UserTypes.getJspName()).forward(request, response);
    }


}
