package Pilot;

public class PersonalMinimums {
    private int maxWindSpeed;
    private int maxCrossWind;
    private int minVisibility;
    private int minCeiling;
    private int minVisibilityNight;
    private int minCeilingNight;

    public int getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setMaxWindSpeed(int maxWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
    }

    public int getMaxCrossWind() {
        return maxCrossWind;
    }

    public void setMaxCrossWind(int maxCrossWind) {
        this.maxCrossWind = maxCrossWind;
    }

    public int getMinVisibility() {
        return minVisibility;
    }

    public void setMinVisibility(int minVisibility) {
        this.minVisibility = minVisibility;
    }

    public int getMinCeiling() {
        return minCeiling;
    }

    public void setMinCeiling(int minCeiling) {
        this.minCeiling = minCeiling;
    }

    public int getMinVisibilityNight() {
        return minVisibilityNight;
    }

    public void setMinVisibilityNight(int minVisibilityNight) {
        this.minVisibilityNight = minVisibilityNight;
    }

    public int getMinCeilingNight() {
        return minCeilingNight;
    }

    public void setMinCeilingNight(int minCeilingNight) {
        this.minCeilingNight = minCeilingNight;
    }

    public PersonalMinimums(int maxWind, int maxCross, int minVis, int minCeil) {
        maxWindSpeed = maxWind;
        maxCrossWind = maxCross;
        minVisibility = minVis;
        minCeiling = minCeil;
    }

    public PersonalMinimums(int maxWind, int maxCross, int minVis, int minCeil, int minVisNight, int minCeilNight) {
        maxWindSpeed = maxWind;
        maxCrossWind = maxCross;
        minVisibility = minVis;
        minCeiling = minCeil;
        minVisibilityNight = minVisNight;
        minCeilingNight = minCeilNight;
    }

    public String toString() {
        String out = "Personal Minimums: \nMaximum Wind: " + getMaxWindSpeed() + "\nMaximum Crosswind: " + getMaxCrossWind() + "\nMinimum Visibility: "
                + getMinVisibility() + "\nMinimum Ceiling: " + getMinCeiling() + "\n";
        return out;
    }
}
