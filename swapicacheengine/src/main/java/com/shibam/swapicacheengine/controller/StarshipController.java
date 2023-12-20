package com.shibam.swapicacheengine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.model.Starship;
import com.shibam.swapicacheengine.service.StarshipService;

import java.util.List;

@RestController
@RequestMapping("/api/starships")
public class StarshipController {

    private final StarshipService starshipService;
    private final SwapiCache swapiCache;

    @Autowired
    public StarshipController(StarshipService starshipService, SwapiCache swapiCache) {
        this.starshipService = starshipService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
	@GetMapping
    public List<Starship> getAllStarships() {
        // Check if starships are already in the cache
        if (swapiCache.containsKey("starships")) {
            return (List<Starship>) swapiCache.get("starships");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Starship> starships = starshipService.getAllStarships();
        swapiCache.put("starships", starships);
        return starships;
    }

    @GetMapping("/{name}")
    public Starship getStarshipByName(@PathVariable String name) {
        // Check if starships are already in the cache
        if (swapiCache.containsKey("starships")) {
            @SuppressWarnings("unchecked")
			List<Starship> starshipList = (List<Starship>) swapiCache.get("starships");

            // Find the starship by name in the cached data
            return findStarshipByName(starshipList, name);
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Starship> starships = starshipService.getAllStarships();
        swapiCache.put("starships", starships);

        // Find the starship by name in the fetched data
        return findStarshipByName(starships, name);
    }

    private Starship findStarshipByName(List<Starship> starshipList, String name) {
        return starshipList.stream()
                .filter(starship -> starship.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Additional endpoints, e.g., search starships, can be added as needed
}
