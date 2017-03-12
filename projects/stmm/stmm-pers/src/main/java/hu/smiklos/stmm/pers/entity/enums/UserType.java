package hu.smiklos.stmm.pers.entity.enums;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public enum UserType {
    REGISTERED("REGISTERED"),
    RELIABLE("RELIABLE"),
    SUSPICIOUS("SUSPICIOUS"),
    OWING("OWING");

    private String userType;

    private UserType(final String type){
        this.userType = type;
    }

    public String getUserType() {
        return this.userType;
    }

}
