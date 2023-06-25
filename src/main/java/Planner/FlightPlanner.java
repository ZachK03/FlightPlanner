package Planner;

import Aircraft.Airplane;
import Airport.Airport;
import Pilot.Pilot;
import Pilot.PersonalMinimums;
import Weather.AirportWeather;
import Weather.CloudLayer;

public class FlightPlanner {
    private double distance(Airport a1, Airport a2) {
        final int R = 6371; // Radius of the earth
        double lat1 = a1.getLatitude();
        double lat2 = a2.getLatitude();
        double lon1 = a1.getLongitude();
        double lon2 = a2.getLongitude();
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = (R * c * 1000);

        distance = Math.pow(distance, 2);

        distance = Math.sqrt(distance) * 0.0005399568;
        distance = (Math.round(distance * 10.0)) / 10.0;

        return distance;
    }

    private int direction(Airport a1, Airport a2) {
        int dir = -1;
        //TODO : Implement direction from lat/long coords
        return dir;
    }

    private boolean canFlyGivenCloudLayers(Airport airport, PersonalMinimums personalMins) {
        for (CloudLayer cl : airport.getWeather().getClouds()) {
            if ((cl.getM_layerType() == CloudLayer.LayerType.OVERCAST || cl.getM_layerType() == CloudLayer.LayerType.BROKEN) && cl.getM_altitude() < personalMins.getMinCeiling()) {
                System.out.println("Ceiling below minimum at " + airport.getIdentifier());
                System.out.println("Minimum: " + personalMins.getMinCeiling() + "\nActual: " + cl.getM_altitude());
                System.out.println(cl.getM_layerType());
                return false;
            }
        }
        return true;
    }

    private boolean canPilotFlyTo(Pilot pilot, Airport a1, Airport a2) {
        PersonalMinimums personalMins = pilot.getPersonalMins();
        if(personalMins.getMaxCrossWind() < a1.getCrossWind()) {
            System.out.println("Maximum personal crosswind exceeded at " + a1.getIdentifier());
            System.out.println("Maximum: " + personalMins.getMaxCrossWind() + "\nActual: " + a1.getCrossWind());
            return false;
        }
        if(personalMins.getMaxCrossWind() < a2.getCrossWind()) {
            System.out.println("Maximum personal crosswind exceeded at " + a2.getIdentifier());
            System.out.println("Maximum: " + personalMins.getMaxCrossWind() + "\nActual: " + a2.getCrossWind());
            return false;
        }

        AirportWeather aw1 = a1.getWeather();
        AirportWeather aw2 = a2.getWeather();

        if(!canFlyGivenCloudLayers(a1,personalMins)) return false;
        if(!canFlyGivenCloudLayers(a2,personalMins)) return false;

        if(aw1.getM_visibility() < personalMins.getMinVisibility()) {
            System.out.println("Visibility below minimum at " + a1.getIdentifier());
            System.out.println("Minimum: " + personalMins.getMinVisibility() + "\nActual: " + aw1.getM_visibility());
            return false;
        }
        if(aw2.getM_visibility() < personalMins.getMinVisibility()) {
            System.out.println("Visibility below minimum at " + a2.getIdentifier());
            System.out.println("Minimum: " + personalMins.getMinVisibility() + "\nActual: " + aw2.getM_visibility());
            return false;
        }

        return true;
    }

    private boolean canAirplaneFlyTo(Airplane airplane, Airport a1, Airport a2) {
        if(airplane.getMaxCrossWind() < a1.getCrossWind()) {
            System.out.println("Maximum crosswind exceeded at " + a1.getIdentifier());
            System.out.println("Maximum: " + airplane.getMaxCrossWind() + "\nActual: " + a1.getCrossWind());
            return false;
        }
        if(airplane.getMaxCrossWind() < a2.getCrossWind()) {
            System.out.println("Maximum crosswind exceeded at " + a2.getIdentifier());
            System.out.println("Maximum: " + airplane.getMaxCrossWind() + "\nActual: " + a2.getCrossWind());
            return false;
        }
        double dist = distance(a1, a2);
        double time = dist / airplane.getCruiseAirspeed();
        time = (Math.round(time * 10.0)) / 10.0;

        double fuelUsed = (time + 0.5) * airplane.getBurnRate();
        fuelUsed = (Math.round(fuelUsed * 10.0)) / 10.0;
        if(airplane.getMaxUsableFuel() - fuelUsed < 0) {
            System.out.println("Cannot make without using all fuel.");
            return false;
        } else if(airplane.getMaxUsableFuel() - fuelUsed < airplane.getBurnRate()) {
            System.out.println("Less than 1 hour of fuel upon arrival.");
            return false;
        }
        System.out.println("Distance: " + dist + " nm\nTime: " + time + " hours\nFuel used: " + fuelUsed + " gal\nBest runway (" + a1.getIdentifier() + "): " + a1.getBestRunway() + "\nBest runway (" + a2.getIdentifier() + "): " + a2.getBestRunway() + "\n");
        return true;
    }

    public boolean canFlyTo(Airplane airplane, Airport a1, Airport a2) {
        if(!canAirplaneFlyTo(airplane, a1, a2)) return false;
        return true;
    }

    public boolean canFlyTo(Airplane airplane, Airport a1, Airport a2, Pilot pilot) {
        if(!canPilotFlyTo(pilot, a1, a2)) return false;
        return canFlyTo(airplane,a1,a2);
    }

    public boolean canFlyTo(Airplane airplane, Airport a1, Airport a2, Pilot pilot, int altitude) {
        System.out.println("Not finished");
        return false;
    }
}
