package hu.smiklos.stmm.ejb.domain;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public class AppUserStub {
    private String appuserId;
    private String walletId;

    public AppUserStub() {

    }

    public AppUserStub(String appuserId, String walletId) {
        this.appuserId = appuserId;
        this.walletId = walletId;
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
