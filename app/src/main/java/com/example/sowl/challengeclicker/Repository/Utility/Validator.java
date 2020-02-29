package com.example.sowl.challengeclicker.Repository.Utility;

public class Validator {

    public static boolean validator(String text) {
        return text.matches("^[A-Za-z0-9]{3,10}$");
    }
}
