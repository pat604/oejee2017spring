package hu.smiklos.stmm.webadmin.servlet;



import hu.smiklos.stmm.webadmin.common.AdminPages;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@PermitAll
@WebServlet("/AdminHome")
public class AdminHomeController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        this.request = request;
        this.response = response;
        this.handleGet();

    }



    private void handleGet() throws ServletException, IOException {
            this.request.getRequestDispatcher(AdminPages.AdminHome.getJspName()).forward(this.request, this.response);
    }


}
