package hu.smiklos.stmm.webadmin.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 13..
 */
public enum AdminPages {
    AdminHome("adminhome.jsp", "/stmm-webadmin/AdminHome"),
    AppUsers("appusers.jsp", "/stmm-webadmin/AppUser"),
    UserTypes("usertypes.jsp", "/stmm-webadmin/UserType"),
    UserHome("", "/stmm-web/Home"),
    EditUser("edituser.jsp", "/stmm-webadmin/AppUser");

    private final String jspName;
    private final String url;

    public String getJspName() {
        return this.jspName;
    }

    public String getUrl() {
        return this.url;
    }

    private AdminPages(final String jspName, final String url) {
        this.jspName = jspName;
        this.url = url;
    }
}
