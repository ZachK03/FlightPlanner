import Airport.Airport;
import Airport.AirportConfigurator;

import static org.junit.jupiter.api.Assertions.*;
class AirportConfiguratorTest {
    private AirportConfigurator airportConfig = new AirportConfigurator();


    @org.junit.jupiter.api.Test
    void testKORL() throws Exception {
        Airport airport = airportConfig.getAirportInfo("KORL");
        System.out.println(airport);
        assertNotNull(airport);
    }

    @org.junit.jupiter.api.Test
    void testKLEE() throws Exception {
        Airport airport = airportConfig.getAirportInfo("KLEE");
        System.out.println(airport);
        assertNotNull(airport);
    }

    @org.junit.jupiter.api.Test
    void testKMCO() throws Exception {
        Airport airport = airportConfig.getAirportInfo("KMCO");
        System.out.println(airport);
        assertNotNull(airport);
    }

    @org.junit.jupiter.api.Test
    void testKLAX() throws Exception {
        Airport airport = airportConfig.getAirportInfo("KLAX");
        System.out.println(airport);
        assertNotNull(airport);
    }

    @org.junit.jupiter.api.Test
    void testKJFK() throws Exception {
        Airport airport = airportConfig.getAirportInfo("KJFK");
        System.out.println(airport);
        assertNotNull(airport);
    }
}