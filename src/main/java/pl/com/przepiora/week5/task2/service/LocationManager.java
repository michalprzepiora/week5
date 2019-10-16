package pl.com.przepiora.week5.task2.service;

import org.springframework.web.client.RestTemplate;
import pl.com.przepiora.week5.task2.model.Location;

import java.util.Arrays;
import java.util.List;

public class LocationManager {
    private RestTemplate restTemplate;

    public LocationManager() {
        restTemplate = new RestTemplate();
    }

    public List<Location> getLocationsList(String keyword) {
        String url = "https://www.metaweather.com/api/location/search/?query=" + keyword;
        Location[] locationArray = restTemplate.getForObject(url, Location[].class);
        return Arrays.asList(locationArray);
    }
}
