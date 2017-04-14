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

    }

    public AppUserStub(String appuserId, String walletId, String firstName, String lastName) {
        this.appuserId = appuserId;
        this.walletId = walletId;
        this.firstName = firstName;
        this.lastName = lastName;
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
