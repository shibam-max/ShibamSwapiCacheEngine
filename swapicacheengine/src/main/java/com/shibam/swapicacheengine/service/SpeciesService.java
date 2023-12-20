package com.shibam.swapicacheengine.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shibam.swapicacheengine.model.Species;

import java.util.Arrays;
import java.util.List;

@Service
public class SpeciesService {

    private final RestTemplate restTemplate;

    @Autowired
    public SpeciesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Species> getAllSpecies() {
        String url = "https://swapi.dev/api/species/";
        Species[] speciesArray = restTemplate.getForObject(url, Species[].class);
        return Arrays.asList(speciesArray);
    }

    public Species getSpeciesByName(String name) {
        List<Species> species = getAllSpecies();
        return findSpeciesByName(species, name);
    }

    private Species findSpeciesByName(List<Species> speciesList, String name) {
        return speciesList.stream()
                .filter(species -> species.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
