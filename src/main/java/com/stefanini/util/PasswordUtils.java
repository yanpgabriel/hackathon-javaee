package com.stefanini.util;

import javax.enterprise.context.ApplicationScoped;
import java.util.Base64;

@ApplicationScoped
public class PasswordUtils {

    public Boolean isValidPassword(String password){
        Boolean hasAtLeast1UppercaseLetter = password.matches(".*[A-Z]+.*");
        Boolean hasAtLeast1LowercaseLetter = password.matches(".*[a-z]+.*");
        Boolean hasAtLeast1Digit = password.matches(".*\\d+.*");
        Boolean hasAtLeast1SpecialLetter = password.matches(".*[^a-zA-Z0-9]+.*");

        return hasAtLeast1Digit && hasAtLeast1SpecialLetter && hasAtLeast1LowercaseLetter && hasAtLeast1UppercaseLetter;
    }

    public String decodeBase64(String encodedPassword){
        return new String(Base64.getDecoder().decode(encodedPassword));
    }

    public String encodeBase64(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean passwordMatches(String encodedPassword, String password){
        return decodeBase64(encodedPassword).equals(password);
    }
}
