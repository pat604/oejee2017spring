package hu.smiklos.stmm.webadmin.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 13..
 */
public enum Page {
    AdminHome("adminhome.jsp", "AdminHome");


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
