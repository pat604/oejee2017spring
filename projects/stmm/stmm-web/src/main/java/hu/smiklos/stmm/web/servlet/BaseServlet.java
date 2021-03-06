package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.servlet.interfaces.ForwardInterface;
import hu.smiklos.stmm.web.servlet.interfaces.HandleGetInterface;
import hu.smiklos.stmm.web.servlet.interfaces.HandlePostInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
public abstract class BaseServlet extends HttpServlet implements HandleGetInterface, HandlePostInterface, ForwardInterface {
    protected HttpServletRequest request;
    HttpServletResponse response;

    protected BaseServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        try {
            this.handleGet();
        } catch (PersistenceServiceException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        try {
            this.handlePost();
        } catch (PersistenceServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forward(String jspName) throws ServletException, IOException {
        request.getRequestDispatcher(jspName).forward(request, response);
    }

    public abstract void handlePost() throws ServletException, IOException, PersistenceServiceException;

    public abstract void handleGet() throws ServletException, IOException, PersistenceServiceException;

}