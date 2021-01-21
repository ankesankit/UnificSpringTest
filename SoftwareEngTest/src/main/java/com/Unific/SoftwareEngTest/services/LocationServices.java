package com.Unific.SoftwareEngTest.services;

import com.Unific.SoftwareEngTest.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class LocationServices {

    @Autowired
    RestTemplate restTemplate;

    public Location.ResultLocation[] getLocations( String type ){

        final String GET_LOCATION_URL = "https://rickandmortyapi.com/api/location/?type={type}";

        HashMap<String, String> params = new HashMap<>();
        params.put( "type", type );
        Location getLocations = restTemplate.getForObject( GET_LOCATION_URL, Location.class, params );

        return getLocations.getResults();
    }

}
