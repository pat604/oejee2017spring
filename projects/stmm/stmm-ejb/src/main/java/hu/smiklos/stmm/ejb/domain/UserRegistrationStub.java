package hu.smiklos.stmm.ejb.domain;

import hu.smiklos.stmm.ejb.common.Errors;

import javax.validation.constraints.NotNull;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
public class UserRegistrationStub {

    public static String FIRST_NAME= "first_name";
    public static String LAST_NAME = "last_name";
    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String PASSWORD_AGAIN = "password_again";

    private String first_name;


    private String last_name;


    private String username;

    private String password;


    private String password_again;

    private String userId;

    private Errors errors;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_again() {
        return password_again;
    }

    public void setPassword_again(String password_again) {
        this.password_again = password_again;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isValid() {
        errors = new Errors();
        if(first_name.isEmpty()){
            errors.add(FIRST_NAME, "First name empty");
        }
        if(last_name.isEmpty()){
            errors.add(LAST_NAME, "Last name is empty");
        }
        if(password.isEmpty()){
            errors.add(PASSWORD, "Password is empty");
        }
        if(password_again.isEmpty()) {
            errors.add(PASSWORD_AGAIN, "Repeat password");
        }
        if(!password.equals(password_again)){
            errors.add("password_mismatch", "Password missmatch");
        }
        if(username.isEmpty()){
            errors.add(USERNAME, "Username empty");
        }
        return !errors.hasError();
    }

    public Errors getErrors() {
        return errors;
    }
}
