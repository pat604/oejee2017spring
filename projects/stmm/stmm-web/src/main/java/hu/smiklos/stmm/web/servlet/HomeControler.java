package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.web.common.Page;

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
@WebServlet("/Home")
public class HomeControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getRequestDispatcher(Page.HOME.getJspName()).forward(request, response);
    }
}
