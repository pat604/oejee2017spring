package hu.smiklos.stmm.web.servlet.interfaces;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
public interface ForwardInterface {
    void forward(String jspName) throws ServletException, IOException;
}
