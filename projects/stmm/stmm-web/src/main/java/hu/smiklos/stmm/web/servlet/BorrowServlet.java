package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.web.common.Page;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@PermitAll
@WebServlet("/Borrow")
public class BorrowServlet extends BaseServlet {


    public BorrowServlet() {

    }

    @Override
    public void handlePost() throws ServletException, IOException {
        forward(Page.BORROW.getJspName());
    }

    @Override
    public void handleGet() throws ServletException, IOException {
        forward(Page.BORROW.getJspName());
    }

}
