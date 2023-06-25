package Airport;

import Weather.AirportWeather;

import java.util.ArrayList;

public class Airport {
    private String identifier;
    private AirportWeather weather;
    private double latitude;
    private double longitude;
    private double elevation;
    private ArrayList<Runway> runways;
    private String bestRunway;
    private int crossWind;
    private int headWind;

    public int getCrossWind() {
        return crossWind;
    }

    public void setCrossWind(int crossWind) {
        this.crossWind = crossWind;
    }

    public int getHeadWind() {
        return headWind;
    }

    public void setHeadWind(int headWind) {
        this.headWind = headWind;
    }

    public String getBestRunway() {
        return bestRunway;
    }

    public void setBestRunway(String bestRunway) {
        this.bestRunway = bestRunway;
    }

    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public AirportWeather getWeather() {
        return weather;
    }
    public void setWeather(AirportWeather weather) {
        this.weather = weather;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getElevation() {
        return elevation;
    }
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }
    public ArrayList<Runway> getRunways() {
        return runways;
    }
    public void setRunways(ArrayList<Runway> runways) {
        this.runways = runways;
    }

    public String toString() {
        String out = "";
        out += "Airport: " + getIdentifier() + "\nLatitude: " + getLatitude();
        if(getLatitude() < 0)
            out += "°S";
        else
            out += "°N";
        out += "\nLongitude: " + getLongitude();
        if(getLongitude() < 0)
            out += "°W";
        else
            out += "°E";
        out += "\nElevation: " + getElevation() + " ft MSL\nRunways: \n";
        if(getRunways().size() <= 0) {
            out += "    Undetected";
            return out;
        }
        for(int i = 0; i < getRunways().size(); i++) {
            Runway r = getRunways().get(i);
            out += r.toString();
        }
        out += "Best Runway Given Wx: " + getBestRunway() + "\nCrosswind: " + getCrossWind() + " kts\nHeadwind: " + getHeadWind() + " kts";
        return out;
    }
}
