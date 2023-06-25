import Aircraft.Airplane;
import Airport.Airport;
import Airport.AirportConfigurator;
import Pilot.Pilot;
import Pilot.PersonalMinimums;
import Planner.FlightPlanner;

public class Main {
    private static AirportConfigurator airportConfig = new AirportConfigurator();
    private static FlightPlanner flightPlan = new FlightPlanner();

    public static void main(String[] args) throws Exception {
        Airport korl = airportConfig.getAirportInfo("KORL");
        Airport klee = airportConfig.getAirportInfo("KLEE");
        Airplane airplane = new Airplane("Piper","N6259W","Piper","Warrior",100, 48, 8.4);
        airplane.setMaxCrossWind(15);
        Pilot myPilot = new Pilot("Zach");
        myPilot.setPersonalMins(new PersonalMinimums(15,9,7,5000));
        System.out.println(myPilot);
        boolean canFly = flightPlan.canFlyTo(airplane,korl,klee,myPilot);
        if(canFly)
            System.out.println("You could fly!");
        else
            System.out.println("You can't fly!");
    }
}



/*

    TODO : Add direction from airport to airport
    TODO : Calculate ground speed for better time/fuel usage calculations
    TODO : Add additional parameter to FlightPlanner.canFlyTo for altitude
    TODO : Add JavaFX UI
    TODO : Get winds aloft data for en-route calculations

 */