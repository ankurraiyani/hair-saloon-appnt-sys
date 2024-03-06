package com.SalonSphereServer.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {

    //validate the Email 
    public static boolean emailValidation(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    //validate contact Number
    public static boolean ContactNumberValidation(String contact_number){
        String phoneRegex = "[0-9]{10}";
		Pattern p = Pattern.compile(phoneRegex);
		Matcher matcher2 = p.matcher(contact_number);

        if (matcher2.matches()) {
            return true;
        } else {
            return false;
        }
    }

    //validate first name
    public static boolean firstNameValidation(String first_name){

        if(first_name.length()>2){
            return true;
        }
        else{
            return false;
        }

    }

    //validate last name
    public static boolean lastNameValidation(String last_name){

        if(last_name.length()>3){
            return true;
        }
        else{
            return false;
        }

    }

    //validate password
    public static boolean passwordValidation(String password){

        String passwordregex = "^(?=.*[!@#$%^&*()-+=])(?=\\S+$).{6,}$";

        Pattern pattern = Pattern.compile(passwordregex);
        Matcher matcher3 = pattern.matcher(password);

        if(password.length()>6 && matcher3.matches()){
            return true;
        }
        else{
            return false;
        }

    }

}
