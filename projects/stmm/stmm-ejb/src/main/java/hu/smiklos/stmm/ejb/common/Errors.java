package hu.smiklos.stmm.ejb.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
public class Errors {

    private Map<String, String> errors;

    public Errors(){

    }

    public void add(String name, String value){
        if(this.errors == null){
            this.errors = new HashMap<String, String>();
        }
        errors.put(name, value);
    }
    public String get(String name){
        return errors.get(name);
    }

    public boolean hasError() {
        return this.errors != null;
    }

    public Map<String, String> getErrorList(){
        return this.errors;
    }
}
