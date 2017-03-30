package hu.smiklos.stmm.ejb.parameternames.web;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
public enum WebParameterName {
    Action("action");

    String paramname;

    WebParameterName(String paramname) {
        this.paramname = paramname;
    }

    public String getName() {
        return paramname;
    }
}
