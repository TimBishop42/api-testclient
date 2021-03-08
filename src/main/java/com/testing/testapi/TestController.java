package com.testing.testapi;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestController {


    @RequestMapping(method = RequestMethod.GET, value = "/testPwned")
    public ResponseEntity<?> getPwned() throws JsonProcessingException {
        System.out.println("Request received");
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);



        String jsonResponse = "[\n" +
                "  {\n" +
                "    \"Name\":\"Adobe\",\n" +
                "    \"Title\":\"Adobe\",\n" +
                "    \"Domain\":\"adobe.com\",\n" +
                "    \"BreachDate\":\"2013-10-04\",\n" +
                "    \"AddedDate\":\"2013-12-04T00:00Z\",\n" +
                "    \"ModifiedDate\":\"2013-12-04T00:00Z\",\n" +
                "    \"PwnCount\":152445165,\n" +
                "    \"Description\":\"In October 2013, 153 million Adobe accounts were breached with each containing an internal ID, username, email, <em>encrypted</em> password and a password hint in plain text. The password cryptography was poorly done and <a href=\\\"http://stricture-group.com/files/adobe-top100.txt\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">many were quickly resolved back to plain text</a>. The unencrypted hints also <a href=\\\"http://www.troyhunt.com/2013/11/adobe-credentials-and-serious.html\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">disclosed much about the passwords</a> adding further to the risk that hundreds of millions of Adobe customers already faced.\",\n" +
                "    \"DataClasses\":[\"Email addresses\",\"Password hints\",\"Passwords\",\"Usernames\"],\n" +
                "    \"IsVerified\":true,\n" +
                "    \"IsFabricated\":false,\n" +
                "    \"IsSensitive\":false,\n" +
                "    \"IsRetired\":false,\n" +
                "    \"IsSpamList\":false,\n" +
                "    \"LogoPath\":\"https://haveibeenpwned.com/Content/Images/PwnedLogos/Adobe.png\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Name\":\"BattlefieldHeroes\",\n" +
                "    \"Title\":\"Battlefield Heroes\",\n" +
                "    \"Domain\":\"battlefieldheroes.com\",\n" +
                "    \"BreachDate\":\"2011-06-26\",\n" +
                "    \"AddedDate\":\"2014-01-23T13:10Z\",\n" +
                "    \"ModifiedDate\":\"2014-01-23T13:10Z\",\n" +
                "    \"PwnCount\":530270,\n" +
                "    \"Description\":\"In June 2011 as part of a final breached data dump, the hacker collective &quot;LulzSec&quot; <a href=\\\"http://www.rockpapershotgun.com/2011/06/26/lulzsec-over-release-battlefield-heroes-data\\\" target=\\\"_blank\\\" rel=\\\"noopener\\\">obtained and released over half a million usernames and passwords from the game Battlefield Heroes</a>. The passwords were stored as MD5 hashes with no salt and many were easily converted back to their plain text versions.\",\n" +
//                "    \"DataClasses\":[\"Passwords\",\"Usernames\"],\n" +
                "    \"IsVerified\":true,\n" +
                "    \"IsFabricated\":false,\n" +
                "    \"IsSensitive\":false,\n" +
                "    \"IsRetired\":false,\n" +
                "    \"IsSpamList\":false,\n" +
                "    \"LogoPath\":\"https://haveibeenpwned.com/Content/Images/PwnedLogos/BattlefieldHeroes.png\"\n" +
                "  }\n" +
                "]";

        List<Pwned> pwned = objectMapper.readValue(jsonResponse, new TypeReference<List<Pwned>>(){});
        return new ResponseEntity<List<Pwned>>(pwned, HttpStatus.OK);


    }
}
