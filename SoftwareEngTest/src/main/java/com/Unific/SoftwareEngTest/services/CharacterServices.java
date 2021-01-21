package com.Unific.SoftwareEngTest.services;

import com.Unific.SoftwareEngTest.Models.Character;
import com.Unific.SoftwareEngTest.Models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CharacterServices {

    @Autowired
    RestTemplate restTemplate;

    public Result[] getCharacters( String gender, String status) {

        final String GET_CHARACTERS_URL = "https://rickandmortyapi.com/api/character/?gender={gender}&status={status}";

        HashMap<String, String> params = new HashMap<>();
        params.put( "gender", gender );
        params.put( "status", status );
        Character getCharacters = restTemplate.getForObject( GET_CHARACTERS_URL, Character.class, params );

        return getCharacters.getResults();

    }
}
