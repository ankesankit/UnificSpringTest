package com.Unific.SoftwareEngTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Location {

    private Info info;
    private ResultLocation [] results;

    @Data
    public static class ResultLocation {

        @JsonProperty
        private int id;

        @JsonProperty
        private String name;

        @JsonProperty
        private String type;

        @JsonProperty
        private String dimension;

        @JsonProperty
        private String [] residents;

        @JsonProperty
        private String url;

        @JsonProperty
        private String created;
    }
}
