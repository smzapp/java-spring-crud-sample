package com.crudtest.demo.util;

import com.crudtest.demo.exception.SearchEntryException;

public class AgeRange {

    private String ageRange;
    private String ageFrom;
    private String ageTo;
    private boolean isRange = false;

    public AgeRange(String ageRange)  {
        this.ageRange = ageRange;
    }

    public void initialize() throws SearchEntryException {
        String[] age = this.ageRange.split("-");
        if (age.length == 2) {
            String fromAge = age[0];
            String toAge = age[1];
            int from = Integer.parseInt(fromAge);
            int to = Integer.parseInt(toAge);
            if (from > to) {
                throw new SearchEntryException("age", "Age Range Error: From should be less than or equal to TO.");
            }
            this.setAgeFrom(fromAge);
            this.setAgeTo(toAge);
            this.setIsValidRange(true);
        } else {
            throw new SearchEntryException("age", "Age range is invalid!");
        }
    }

    private boolean isValidRange() {
        return this.isRange;
    }

    private void setIsValidRange(boolean result) {
        this.isRange = result;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public int getAgeFrom() {
        return Integer.parseInt(this.ageFrom);
    }

    public int getAgeTo() {
        return Integer.parseInt(this.ageTo);
    }
}
