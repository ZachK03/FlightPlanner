package Weather;

import Weather.Wind;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AirportWeather {
    private String location;
    private String time;
    private int day;
    private boolean automatic = false;
    private Wind m_wind;
    private int m_visibility;
    ArrayList<CloudLayer> clouds;
    private int temperature;
    private int dewPoint;
    private double altimeterSetting;
    private String remarks;

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getTime() {
        return time;
    }
    public Wind getWind() {
        return m_wind;
    }
    public void setWind(Wind wind) {
        this.m_wind = wind;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public int getDewPoint() {
        return dewPoint;
    }
    public void setDewPoint(int dewPoint) {
        this.dewPoint = dewPoint;
    }
    public double getAltimeterSetting() {
        return altimeterSetting;
    }
    public void setAltimeterSetting(double altimeterSetting) {
        this.altimeterSetting = altimeterSetting;
    }
    public boolean isAutomatic() {
        return automatic;
    }
    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }
    public String getTime(boolean format) {
        return time;
    }
    public String getFormattedTime() {
        String formattedTime = time.substring(0, 2) + ":" + time.substring(2);
        return formattedTime;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getM_visibility() {
        return m_visibility;
    }
    public void setM_visibility(int m_visibility) {
        this.m_visibility = m_visibility;
    }
    public ArrayList<CloudLayer> getClouds() {
        return clouds;
    }
    public void setClouds(ArrayList<CloudLayer> clouds) {
        this.clouds = clouds;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public AirportWeather() {}

    public String toString() {
        String out = "";
        Calendar cal = Calendar.getInstance();
        String suffix = "th";
        switch(getDay()) {
            case 1:
                suffix = "st";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
        }
        out += "Airport: " + getLocation() + "\nTime: " + getFormattedTime() + ", " + new SimpleDateFormat("MMM").format(cal.getTime()) + " " +getDay() + suffix + "\n";
        if(isAutomatic())
            out += "Automated Report\n";
        out += getWind().toString() + "\nVisibility: " + getM_visibility() + "SM\n";
        for(CloudLayer cl : getClouds())
            out += cl.toString() + "\n";
        out += "Temperature: " + getTemperature() + "°C\nDew Point: " + getDewPoint() + "°C\nAltimeter setting: " + getAltimeterSetting() + "\" Hg\nRemarks: " + getRemarks();
        return out;
    }
}
