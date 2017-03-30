package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.ejb.facade.UserRegistrationFacadeInterface;
import hu.smiklos.stmm.web.common.Page;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
@WebServlet("/Registration")
public class UserRegistrationController extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;

    @EJB
    private UserRegistrationFacadeInterface facade;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.request = request;
        this.response = response;
        handleGet();
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.request = request;
        this.response = response;
        this.handlePost();
    }

    private void handlePost() throws ServletException, IOException {
        String first_name = request.getParameter(UserRegistrationStub.FIRST_NAME);
        String last_name = request.getParameter(UserRegistrationStub.LAST_NAME);
        String password = request.getParameter(UserRegistrationStub.PASSWORD);
        String password_again = request.getParameter(UserRegistrationStub.PASSWORD_AGAIN);
        String username = request.getParameter(UserRegistrationStub.USERNAME);
        request.getRequestDispatcher(Page.USER_REGISTRATION.getJspName()).forward(request, response);
    }

    private void handleGet() throws ServletException, IOException {
        request.getRequestDispatcher(Page.USER_REGISTRATION.getJspName()).forward(request, response);
    }


}
