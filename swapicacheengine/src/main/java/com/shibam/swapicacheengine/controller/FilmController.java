package com.shibam.swapicacheengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.model.Film;
import com.shibam.swapicacheengine.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;
    private final SwapiCache swapiCache;

    @Autowired
    public FilmController(FilmService filmService, SwapiCache swapiCache) {
        this.filmService = filmService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
    @GetMapping
    public List<Film> getAllFilms() {
        // Check if films are already in the cache
        if (swapiCache.containsKey("films")) {
            return (List<Film>) swapiCache.get("films");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Film> films = filmService.getAllFilms();
        swapiCache.put("films", films);
        return films;
    }

    @GetMapping("/{title}")
    public Film getFilmByTitle(@PathVariable String title) {
        // Check if film is already in the cache
        String cacheKey = "film_" + title;
        if (swapiCache.containsKey(cacheKey)) {
            return (Film) swapiCache.get(cacheKey);
        }

        // If not in the cache, fetch from the service and store in the cache
        Film film = filmService.getFilmByTitle(title);
        swapiCache.put(cacheKey, film);
        return film;
    }

    // Additional endpoints, e.g., search films, can be added as needed
}
