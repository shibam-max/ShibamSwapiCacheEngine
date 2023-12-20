package com.shibam.swapicacheengine.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shibam.swapicacheengine.model.Planet;

import java.util.Arrays;
import java.util.List;

@Service
public class PlanetService {

    private final RestTemplate restTemplate;

    @Autowired
    public PlanetService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Planet> getAllPlanets() {
        String url = "https://swapi.dev/api/planets/";
        Planet[] planetsArray = restTemplate.getForObject(url, Planet[].class);
        return Arrays.asList(planetsArray);
    }

    public Planet getPlanetByName(String name) {
        List<Planet> planets = getAllPlanets();
        return findPlanetByName(planets, name);
    }

    private Planet findPlanetByName(List<Planet> planets, String name) {
        return planets.stream()
                .filter(planet -> planet.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
