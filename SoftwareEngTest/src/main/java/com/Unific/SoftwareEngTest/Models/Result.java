package com.Unific.SoftwareEngTest.Models;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Result{
    int id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    Origin origin;
    GetLocation location;
    String image;
    String []episode;
    String url;
    Timestamp created;
}
