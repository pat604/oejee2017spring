package hu.smiklos.stmm.web.common;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
public class Dialog {
    public final static String ATTR_DIALOG = "dialog_show";

    private String title;
    private String message;
    private String url;
    private String action;
    private String buttontext;

    public Dialog() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getButtontext() {
        return buttontext;
    }

    public void setButtontext(String buttontext) {
        this.buttontext = buttontext;
    }
}
