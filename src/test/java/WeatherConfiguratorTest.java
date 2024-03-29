import Weather.AirportWeather;
import Weather.WeatherConfigurator;

import static org.junit.jupiter.api.Assertions.*;
class WeatherConfiguratorTest {
    private WeatherConfigurator wxConfig = new WeatherConfigurator();

    @org.junit.jupiter.api.Test
    void testKORL() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KORL");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKLEE() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KLEE");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKMCO() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KMCO");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKLAX() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KLAX");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKJFK() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KJFK");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKTPA() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KTPA");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKMLB() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KMLB");
        System.out.println(wx);
        assertNotNull(wx);
    }

    @org.junit.jupiter.api.Test
    void testKPQI() throws Exception {
        AirportWeather wx = wxConfig.getWeather("KPQI");
        System.out.println(wx);
        assertNotNull(wx);
    }
}