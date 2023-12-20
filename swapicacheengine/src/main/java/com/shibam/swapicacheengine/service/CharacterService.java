package com.shibam.swapicacheengine.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CharacterService {

    private final RestTemplate restTemplate;

    @Autowired
    public CharacterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Character> getAllCharacters() {
        String url = "https://swapi.dev/api/people/";
        Character[] charactersArray = restTemplate.getForObject(url, Character[].class);
        return Arrays.asList(charactersArray);
    }

    public Character getCharacterByName(String name) {
        String url = "https://swapi.dev/api/people/?search=" + name;
        Character[] charactersArray = restTemplate.getForObject(url, Character[].class);

        // Assuming the first result in the array is the desired character
        if (charactersArray != null && charactersArray.length > 0) {
            return charactersArray[0];
        } else {
            // Handle the case when the character is not found
            return null;
        }
    }
}
