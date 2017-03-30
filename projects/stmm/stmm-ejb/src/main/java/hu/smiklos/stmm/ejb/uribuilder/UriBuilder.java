package hu.smiklos.stmm.ejb.uribuilder;

import hu.smiklos.stmm.ejb.parameternames.web.WebParameterName;

/**
 * Created by SebestyenMiklos on 2017. 03. 21..
 */
public class UriBuilder {


    private UriBuilder() {

    }

    public static String getUrl( String url,String action){
        String fullUrl =  url + "?" + WebParameterName.Action.getName() + "=" + action;
        return fullUrl;
    }


}
