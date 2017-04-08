package hu.pat604.dogschool.ejbservice.domain;

/**
 * Created by pati on 2017-03-29.
 */

    public enum CourseTypeStub {

        BASIC("Basic"),
        MEDIUM("Medium"),
        THERAPY("Therapy");

        private final String label;

        private CourseTypeStub(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }

        public String getName() {
            return this.name();
        }

    }
