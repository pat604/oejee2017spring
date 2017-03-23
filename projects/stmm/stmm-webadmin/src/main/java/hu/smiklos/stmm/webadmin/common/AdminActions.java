package hu.smiklos.stmm.webadmin.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
public enum AdminActions {
    ListUserAction("listuser"),
    EditUser("edituser");

    String action;

    private AdminActions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public AdminActions getAction(String action){
        if (action.equals("listuser")) {
            return AdminActions.ListUserAction;
        } else {
            return null;
        }
    }
}
