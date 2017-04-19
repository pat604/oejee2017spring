package hu.smiklos.stmm.ejb.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public class AppUserStub {

    private String appuserId;

    private String walletId;

    private String firstName;

    private String lastName;

    public AppUserStub(String userId, String first_name, String last_name) {
        this.appuserId = userId;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAppuserId() {
        return appuserId;
    }

    public String getWalletId() {
        return walletId;
    }

    @Override
    public String toString() {
        return "AppUserStub{" +
                "appuserId='" + appuserId + '\'' +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
