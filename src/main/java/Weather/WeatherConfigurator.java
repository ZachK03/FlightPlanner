package Weather;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class WeatherConfigurator {
    private String[] weatherCodes = {"MI","PR","BC","DR","BL","SH","VC","TS","FZ","DZ","RA","SN","SG","IC","PL","GR","GS","UP","RR","FG","FU","VA","DU","SA","HZ","PY","PO","SQ","FC","SS","DS","CB"};
    private String[] cloudCoverCodes = {"SKC","CLR","FEW","SCT","BKN","OVC"};
    public AirportWeather getWeather(String identifier) throws Exception {
        AirportWeather aw = new AirportWeather();
        aw.setLocation(identifier);

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://beta.aviationweather.gov/cgi-bin/data/metar.php?ids=" + identifier))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        if(response.body().length() == 0) {
            System.out.println("Failed to get weather\n");
            return null;
        }

        System.out.println(response.body());
        configureAirportWeather(aw,response.body());
        return aw;
    }

    private void configureAirportWeather(AirportWeather aw, String data) {
        String[] weatherData = data.split(" ");
        int index = 0;
        aw.setLocation(weatherData[index]);
        index++;

        String time = weatherData[index];
        String day = time.substring(0,2);
        time = time.substring(2);
        aw.setDay(Integer.valueOf(day));
        aw.setTime(time);
        index++;

        if("AUTO".equals(weatherData[index])) {
            aw.setAutomatic(true);
            index++;
        }

        String winds = weatherData[index];
        String windDir = winds.substring(0,3);
        String windStrength = winds.substring(3,5);
        boolean windIsVariable = false;
        if("VRB".equals(windDir)) {
            windIsVariable = true;
            windDir = "000";
        }
        Wind wind;
        if('G' == (winds.charAt(5))) {
            wind = new Wind(Integer.valueOf(windDir),Integer.valueOf(windStrength), Integer.valueOf(winds.substring(6,8)));
        } else {
            wind = new Wind(Integer.valueOf(windDir),Integer.valueOf(windStrength));
        }
        if(windIsVariable) {
            wind.setM_isVariable(true);
        }
        aw.setWind(wind);
        index++;

        String vis = weatherData[index];
        vis = vis.substring(0,vis.length() - 2);
        aw.setM_visibility(Integer.valueOf(vis));
        index++;

        while(true) {
            boolean isWeatherCode = false;
            for (String weatherCode : weatherCodes) {
                if (weatherData[index].contains(weatherCode)) {
                    isWeatherCode = true;
                }
            }
            if(!isWeatherCode) {
                break;
            }
            index++;
        }

        ArrayList<CloudLayer> clouds = new ArrayList<CloudLayer>();
        while(true) {
            boolean isCloudCode = false;
            for(String cloudCoverCode : cloudCoverCodes) {
                if(weatherData[index].contains(cloudCoverCode)) {
                    isCloudCode = true;
                    int alt = Integer.valueOf((weatherData[index].substring(3) + "00"));
                    CloudLayer cloud = new CloudLayer(weatherData[index].substring(0,3),alt);
                    clouds.add(cloud);
                }
            }
            if(!isCloudCode) {
                break;
            }
            index++;
        }
        aw.setClouds(clouds);

        aw.setTemperature(Integer.valueOf(weatherData[index].substring(0,2)));
        aw.setDewPoint(Integer.valueOf(weatherData[index].substring(3)));
        index++;

        double altSetting = Integer.valueOf(weatherData[index].substring(1)) / 100.0;
        aw.setAltimeterSetting(altSetting);
        index+=2;

        String remarks = weatherData[index];
        index++;
        while(index < weatherData.length) {
            remarks = remarks + " " + weatherData[index];
            index++;
        }
        aw.setRemarks(remarks);
    }
}
