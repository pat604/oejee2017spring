package hu.smiklos.stmm.webadmin.common;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
public enum AdminActions {
    NullAction(""),
    ListUserAction("listuser"),
    EditUser("edituser"),
    DeleteUser("#"),
    ListUserTypesAction("listusertypes"), EditUserType("editusertype"), DeleteUserType("deleteusertype");

    String action;

    private AdminActions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static AdminActions getAction(String action){
        if (action.equals("listuser")) {
            return AdminActions.ListUserAction;
        } else if(action.equals("listusertypes")){
            return AdminActions.ListUserTypesAction;
        } else {
            return NullAction;
        }
    }
}
