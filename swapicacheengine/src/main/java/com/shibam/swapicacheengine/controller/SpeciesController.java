package com.shibam.swapicacheengine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.model.Species;
import com.shibam.swapicacheengine.service.SpeciesService;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final SwapiCache swapiCache;

    @Autowired
    public SpeciesController(SpeciesService speciesService, SwapiCache swapiCache) {
        this.speciesService = speciesService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
	@GetMapping
    public List<Species> getAllSpecies() {
        // Check if species are already in the cache
        if (swapiCache.containsKey("species")) {
            return (List<Species>) swapiCache.get("species");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Species> species = speciesService.getAllSpecies();
        swapiCache.put("species", species);
        return species;
    }

    @GetMapping("/{name}")
    public Species getSpeciesByName(@PathVariable String name) {
        // Check if species are already in the cache
        if (swapiCache.containsKey("species")) {
            @SuppressWarnings("unchecked")
			List<Species> speciesList = (List<Species>) swapiCache.get("species");

            // Find the species by name in the cached data
            return findSpeciesByName(speciesList, name);
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Species> species = speciesService.getAllSpecies();
        swapiCache.put("species", species);

        // Find the species by name in the fetched data
        return findSpeciesByName(species, name);
    }

    private Species findSpeciesByName(List<Species> speciesList, String name) {
        return speciesList.stream()
                .filter(species -> species.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Additional endpoints, e.g., search species, can be added as needed
}
