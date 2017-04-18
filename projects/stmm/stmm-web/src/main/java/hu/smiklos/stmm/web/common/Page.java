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
    LOGOUT("home.jsp", "Logout"),
    CREDIT_CARD("credit_card.jsp", "CreditCard"),
    MB_WALLET("mb_wallet.jsp", "MBWallet"),
    INVEST("invest.jsp", "Invest"),
    INVESTMENT_LIST("investment_list.jsp","UserInvestments"),
    BORROW("borrow.jsp","Borrow"), OFFER_DETAILS("offer_details.jsp","OfferDetails"), ACCEPT_LOAN_OFFER("accept_loan_offer_form","AcceptLoanOffer");

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
