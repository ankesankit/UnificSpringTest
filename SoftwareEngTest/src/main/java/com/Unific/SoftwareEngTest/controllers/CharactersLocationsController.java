package com.Unific.SoftwareEngTest.controllers;

import com.Unific.SoftwareEngTest.Models.Location;
import com.Unific.SoftwareEngTest.Models.Result;
import com.Unific.SoftwareEngTest.services.CharacterServices;
import com.Unific.SoftwareEngTest.services.LocationServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class CharactersLocationsController {

    @Autowired
    private CharacterServices characterServices;

    @Autowired
    private LocationServices locationServices;

    @Value("${app.outputFileType}")
    private String outputFileType;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping(value = "/getLocations/")
    public Location.ResultLocation[] getLocations( @RequestParam String type )
        throws IOException {

        final Location.ResultLocation[] locations = locationServices.getLocations( type );

        mapper.writeValue( new File( "LocationOutput" + outputFileType ), locations );

        return locations;

    }

    @GetMapping(value = "/get2Characters/")
    public List<Result> getTwoCharacters( @RequestParam String gender, @RequestParam String status )
        throws IOException {

        final Result[] characters = characterServices.getCharacters( gender, status );

        final List<Result> value = Arrays.asList( characters[0], characters[1] );

        mapper.writeValue( new File( "charOutput" + outputFileType ), value );
        return value;

    }

}
