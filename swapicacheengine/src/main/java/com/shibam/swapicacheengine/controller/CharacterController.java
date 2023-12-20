package com.shibam.swapicacheengine.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.service.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;
    private final SwapiCache swapiCache;

    @Autowired
    public CharacterController(CharacterService characterService, SwapiCache swapiCache) {
        this.characterService = characterService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
	@GetMapping
    public List<Character> getAllCharacters() {
        // Check if characters are already in the cache
        if (swapiCache.containsKey("characters")) {
            return (List<Character>) swapiCache.get("characters");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Character> characters = characterService.getAllCharacters();
        swapiCache.put("characters", characters);
        return characters;
    }

    @GetMapping("/{name}")
    public Character getCharacterByName(@PathVariable String name) {
        // Check if character is already in the cache
        String cacheKey = "character_" + name;
        if (swapiCache.containsKey(cacheKey)) {
            return (Character) swapiCache.get(cacheKey);
        }

        // If not in the cache, fetch from the service and store in the cache
        Character character = characterService.getCharacterByName(name);
        swapiCache.put(cacheKey, character);
        return character;
    }

    // Additional endpoints, e.g., search characters, can be added as needed
}
