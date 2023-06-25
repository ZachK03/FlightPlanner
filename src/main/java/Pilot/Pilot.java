package Pilot;

public class Pilot {

    private String name;
    private PersonalMinimums personalMins;
    private boolean ratingIFR = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonalMinimums getPersonalMins() {
        return personalMins;
    }

    public void setPersonalMins(PersonalMinimums personalMins) {
        this.personalMins = personalMins;
    }

    public boolean isRatingIFR() {
        return ratingIFR;
    }

    public void setRatingIFR(boolean ratingIFR) {
        this.ratingIFR = ratingIFR;
    }

    public Pilot(String name) {
        this.name = name;
    }

    public String toString() {
        String out = "Pilot: " + getName() + "\nIFR Rated: " + isRatingIFR() + "\n" + getPersonalMins().toString();
        return out;
    }
}
