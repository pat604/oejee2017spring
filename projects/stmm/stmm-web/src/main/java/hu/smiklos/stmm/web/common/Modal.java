package hu.smiklos.stmm.web.common;

/**
 * Created by SebestyenMiklos on 2017. 04. 09..
 */
public class Modal {
    public final static String ATTR_MODAL = "modal_show";

    private String title;
    private String message;

    public Modal() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
