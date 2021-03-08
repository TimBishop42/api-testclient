package com.testing.testapi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pwned {

    private Long id;

    private String userEmail;

    private String name;
    private String title;
    private Date breachDate;
    private String description;
    private Long pwnCount;
    private String domain;
    private Date addedDate;

    private Date modifiedDate;
//    private List<String> DataClasses;
    private boolean isVerified;
    private boolean isFabricated;
    private boolean isSensitive;
    private boolean isRetired;
    private boolean isSpamList;
}
