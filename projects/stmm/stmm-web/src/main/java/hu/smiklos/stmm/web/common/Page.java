package hu.smiklos.stmm.web.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public enum Page {
    HOME("home.jsp", "Home"),
    SIGN_IN("startpage.jsp", "Start"),
    USER_REGISTRATION("userregistration.jsp", "Registration"),
    ERROR("error.jsp", "Error"),
    LOGIN("login.jsp", "Login"),
    LOGOUT("home.jsp", "Logout");


    private final String jspName;
    private final String url;

    private Page(final String jspName, final String url) {
        this.jspName = jspName;
        this.url = url;
    }

    public String getJspName() {
        return this.jspName;
    }

    public String getUrl() {
        return this.url;
    }
}
