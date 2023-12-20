package com.shibam.swapicacheengine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.model.Planet;
import com.shibam.swapicacheengine.service.PlanetService;

import java.util.List;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    private final PlanetService planetService;
    private final SwapiCache swapiCache;

    @Autowired
    public PlanetController(PlanetService planetService, SwapiCache swapiCache) {
        this.planetService = planetService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
	@GetMapping
    public List<Planet> getAllPlanets() {
        // Check if planets are already in the cache
        if (swapiCache.containsKey("planets")) {
            return (List<Planet>) swapiCache.get("planets");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Planet> planets = planetService.getAllPlanets();
        swapiCache.put("planets", planets);
        return planets;
    }

    @GetMapping("/{name}")
    public Planet getPlanetByName(@PathVariable String name) {
        // Check if planets are already in the cache
        if (swapiCache.containsKey("planets")) {
            @SuppressWarnings("unchecked")
			List<Planet> planets = (List<Planet>) swapiCache.get("planets");

            // Find the planet by name in the cached data
            return findPlanetByName(planets, name);
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Planet> planets = planetService.getAllPlanets();
        swapiCache.put("planets", planets);

        // Find the planet by name in the fetched data
        return findPlanetByName(planets, name);
    }

    private Planet findPlanetByName(List<Planet> planets, String name) {
        return planets.stream()
                .filter(planet -> planet.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Additional endpoints, e.g., search planets, can be added as needed
}
