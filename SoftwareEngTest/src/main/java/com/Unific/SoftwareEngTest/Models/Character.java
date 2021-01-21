package com.Unific.SoftwareEngTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Character {

    private Info info;
    private Result [] results;

}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
class Info{

    @JsonProperty
    int count;

    @JsonProperty
    int pages;

    @JsonProperty
    String next;

    @JsonProperty
    String prev;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Origin {
    String name;
    String url;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class GetLocation {
    String name;
    String url;
}


