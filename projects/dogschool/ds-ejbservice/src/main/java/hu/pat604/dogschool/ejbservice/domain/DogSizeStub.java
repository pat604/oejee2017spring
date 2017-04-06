package hu.pat604.dogschool.ejbservice.domain;

/**
 * Created by pati on 2017-03-29.
 */
public enum DogSizeStub {

    MINI("Mini"),
    MIDI("Midi"),
    MAXI("Maxi");

    private final String label;

    private DogSizeStub(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getName() {
        return this.name();
    }

}
