package hu.pat604.dogschool.ejbservice.domain;

/**
 * Created by pati on 2017-03-15.
 */

public enum LevelStub {

    SCHOOL_LEADER("School leader"),
    THERAPY("Therapy"),
    MEDIUM("Medium"),
    BASIC("Basic"),
    ASSISTANT("Assistant");

    private final String label;

    private LevelStub(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name();
    }

}



