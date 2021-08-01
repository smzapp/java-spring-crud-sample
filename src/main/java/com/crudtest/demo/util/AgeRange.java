package com.crudtest.demo.util;

public class AgeRange {

    private String ageRange;
    private String ageFrom;
    private String ageTo;

    public AgeRange(String ageRange) {
        this.ageRange = ageRange;
        this.splitRange();
    }

    private void splitRange() {
//        this.ageRange.split("-");
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }
}
