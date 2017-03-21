package hu.smiklos.stmm.webadmin.servlet;

import hu.smiklos.stmm.webadmin.common.AdminPages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
@WebServlet("/UserType")
public class UserTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(AdminPages.UserTypes.getJspName()).forward(request, response);
    }
}
