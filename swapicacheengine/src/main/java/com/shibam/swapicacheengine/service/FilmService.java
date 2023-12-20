package com.shibam.swapicacheengine.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shibam.swapicacheengine.model.Film;

import java.util.Arrays;
import java.util.List;

@Service
public class FilmService {

    private final RestTemplate restTemplate;

    @Autowired
    public FilmService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Film> getAllFilms() {
        String url = "https://swapi.dev/api/films/";
        Film[] filmsArray = restTemplate.getForObject(url, Film[].class);
        return Arrays.asList(filmsArray);
    }

    public Film getFilmByTitle(String title) {
        String url = "https://swapi.dev/api/films/?search=" + title;
        Film[] filmsArray = restTemplate.getForObject(url, Film[].class);

        // Assuming the first result in the array is the desired film
        if (filmsArray != null && filmsArray.length > 0) {
            return filmsArray[0];
        } else {
            // Handle the case when the film is not found
            return null;
        }
    }
}
