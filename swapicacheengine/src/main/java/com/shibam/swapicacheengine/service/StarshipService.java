package com.shibam.swapicacheengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shibam.swapicacheengine.model.Starship;

import java.util.Arrays;
import java.util.List;

@Service
public class StarshipService {

    private final RestTemplate restTemplate;

    @Autowired
    public StarshipService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Starship> getAllStarships() {
        String url = "https://swapi.dev/api/starships/";
        Starship[] starshipsArray = restTemplate.getForObject(url, Starship[].class);
        return Arrays.asList(starshipsArray);
    }

    public Starship getStarshipByName(String name) {
        List<Starship> starships = getAllStarships();
        return findStarshipByName(starships, name);
    }

    private Starship findStarshipByName(List<Starship> starshipList, String name) {
        return starshipList.stream()
                .filter(starship -> starship.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
