package Airport;

import Weather.AirportWeather;
import Weather.WeatherConfigurator;
import Weather.Wind;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class AirportConfigurator {
    private WeatherConfigurator wxConfig = new WeatherConfigurator();
    public Airport getAirportInfo(String identifier) throws Exception {
        Airport airport = new Airport();
        airport.setIdentifier(identifier);

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://beta.aviationweather.gov/cgi-bin/data/airport.php?ids=" + airport.getIdentifier()))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        if(response.body().length() == 0) {
            System.out.println("Failed to get airport info\n");
            return null;
        }
        //System.out.println(response.body());
        configureAirportInfo(airport,response.body());
        return airport;
    }

    private void configureAirportInfo(Airport airport, String data) throws Exception {
        String identifier = airport.getIdentifier();
        AirportWeather aw = wxConfig.getWeather(identifier);
        airport.setWeather(aw);

        String[] brokenData = data.split("\\n");
        ArrayList<String> usableData = new ArrayList<>();
        for(String s : brokenData) {
            String[] tempSplitString = s.split(":");
            for(String s2 : tempSplitString) {
                usableData.add(s2);
            }
        }
        ArrayList<Runway> runways = new ArrayList<Runway>();
        for(int i = 0; i < usableData.size(); i++) {
            String currentEntry = usableData.get(i).replaceAll("\\s", "");
            if((i + 1) >= usableData.size())
                break;
            String nextEntry = usableData.get(i+1);
            i++;
            switch(currentEntry) {
                case "Latitude":
                    airport.setLatitude(Double.valueOf(nextEntry));
                    break;
                case "Longitude":
                    airport.setLongitude(Double.valueOf(nextEntry));
                    break;
                case "Elevation":
                    Double elev = Double.valueOf(nextEntry);
                    elev *= 3.28084;
                    elev = Math.round(elev * 100.0) / 100.0;
                    airport.setElevation(elev);
                    break;
                case "Runway":
                    Runway runway = new Runway();
                    String runwayDirection = nextEntry.split(" ")[1];
                    runway.setRunwayDirections(runwayDirection.split("/"));

                    String runwayDimensionRaw = usableData.get(i+1).split(" ")[1];
                    String[] runwayDimensions = runwayDimensionRaw.split("x");
                    runway.setLength(Integer.valueOf(runwayDimensions[0]));
                    runway.setWidth(Integer.valueOf(runwayDimensions[1]));

                    String runwaySurface = usableData.get(i+2).split(" ")[1];
                    runway.setSurfaceType(runwaySurface);

                    runways.add(runway);
                default:
                    i--;
                    break;
            }
        }
        airport.setRunways(runways);
        configureWeatherConsiderations(airport);
    }

    private void configureWeatherConsiderations(Airport airport) {
        AirportWeather wx = airport.getWeather();
        Wind wind = wx.getWind();
        int windDir = wind.getM_direction();

        ArrayList<Integer> runwayDirections = new ArrayList<>();
        for(int i = 0; i < airport.getRunways().size(); i++) {
            Runway r = airport.getRunways().get(i);
            for(String dir : r.getRunwayDirections()) {
                runwayDirections.add((Integer.valueOf(dir.substring(0,2)) * 10));
            }
        }

        int bestRunway = runwayDirections.get(0);
        int bestDiff = Math.abs(windDir - bestRunway);
        for(int i = 0; i < runwayDirections.size(); i++) {
            int tempRunwayDir = runwayDirections.get(i);
            int diff = Math.abs(windDir - tempRunwayDir);
            if(diff < bestDiff) {
                bestRunway = tempRunwayDir;
                bestDiff = diff;
            }
        }

        Double diffRadians = Math.toRadians(bestDiff);
        Double sineOfDiff = Math.sin(diffRadians);
        Double cosOfDiff = Math.cos(diffRadians);
        int crossWind = (int) Math.round((sineOfDiff * wind.getM_speed()));
        int headWind = (int) Math.round((cosOfDiff * wind.getM_speed()));

        String bestRunwayStr;
        bestRunway = bestRunway / 10;
        if(bestRunway < 10)
            bestRunwayStr = "0" + String.valueOf(bestRunway);
        else
            bestRunwayStr = String.valueOf(bestRunway);

        airport.setBestRunway(bestRunwayStr);
        airport.setCrossWind(crossWind);
        airport.setHeadWind(headWind);
    }
}
