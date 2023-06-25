package Aircraft;

public class Airplane {
    private String displayName;
    private String callsign;
    private String make;
    private String model;
    private int cruiseAirspeed;
    private int maxUsableFuel;
    private double burnRate;
    private int maxCrossWind;
    private boolean multiEngine;
    private double maxUsefulLoad;
    private double maxRange;

    public Airplane(String name, String callsign, String make, String model, int cruiseAirspeed, int maxFuel, double burnRate) {
        this.setDisplayName(name);
        this.setCallsign(callsign);
        this.setMake(make);
        this.setModel(model);
        this.setCruiseAirspeed(cruiseAirspeed);
        this.setMaxUsableFuel(maxFuel);
        this.setBurnRate(burnRate);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCruiseAirspeed() {
        return cruiseAirspeed;
    }

    public void setCruiseAirspeed(int cruiseAirspeed) {
        this.cruiseAirspeed = cruiseAirspeed;
    }

    public int getMaxUsableFuel() {
        return maxUsableFuel;
    }

    public void setMaxUsableFuel(int maxUsableFuel) {
        this.maxUsableFuel = maxUsableFuel;
    }

    public double getBurnRate() {
        return burnRate;
    }

    public void setBurnRate(double burnRate) {
        this.burnRate = burnRate;
    }

    public int getMaxCrossWind() {
        return maxCrossWind;
    }

    public void setMaxCrossWind(int maxCrossWind) {
        this.maxCrossWind = maxCrossWind;
    }

    public boolean isMultiEngine() {
        return multiEngine;
    }

    public void setMultiEngine(boolean multiEngine) {
        this.multiEngine = multiEngine;
    }

    public double getMaxUsefulLoad() {
        return maxUsefulLoad;
    }

    public void setMaxUsefulLoad(double maxUsefulLoad) {
        this.maxUsefulLoad = maxUsefulLoad;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }
}
