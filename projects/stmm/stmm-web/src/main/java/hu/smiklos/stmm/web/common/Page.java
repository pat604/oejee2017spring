package hu.smiklos.stmm.web.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public enum Page {
    HOME("home.jsp", "Home");


    private final String jspName;
    private final String url;

    public String getJspName() {
        return this.jspName;
    }

    public String getUrl() {
        return this.url;
    }

    private Page(final String jspName, final String url) {
        this.jspName = jspName;
        this.url = url;
    }
}
