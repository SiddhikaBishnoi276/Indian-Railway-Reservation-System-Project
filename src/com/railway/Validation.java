package com.railway;

import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidName(String name) {
        if(name == null || name.trim().isEmpty() || name.equalsIgnoreCase("null")){
            return false;
        }
    return name.trim().matches("^[A-Za-z]+(\\s[A-Za-z]+)?$");
}


    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    public static boolean isValidGender(String gender) {
        return gender != null &&
                (gender.equalsIgnoreCase("M") ||
                 gender.equalsIgnoreCase("F") ||
                 gender.equalsIgnoreCase("O"));
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^[6-9]\\d{9}$");
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && Pattern.matches(regex, email);
    }

    public static boolean isValidIdProof(String id) {
        if (id == null) return false;
        // Format: "aadhar" followed by exactly 4 digits (case insensitive)
        return id.matches("^(?i)aadhar\\d{4}$");
    }

    // username: first name + space + last name format
   // public static boolean isValidUsername(String username) {
   //     return username != null && username.matches("^[A-Za-z]+\\s[A-Za-z]+$");
   // }// new changes 
// username: first name required, last name optional
public static boolean isValidUsername(String username) {
    if(username == null || username.trim().isEmpty() || username.equalsIgnoreCase("null"))
    {
        return false;
    }
    return username.trim().matches("^[A-Za-z]+(\\s[A-Za-z]+)?$");
}
    public static boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d).{6,}$");
    }

    public static boolean isValidPaytmPassword(String password) {
        return password != null && password.matches("^\\d{4,6}$");
    }
    
    public static boolean isValidPNR(String pnr) {
        return pnr != null && pnr.matches("^\\d{10}$");
    }
    
    public static boolean isValidMisuseReason(String reason) {
        if (reason == null || reason.trim().length() < 5) {
            return false;
            
        }
        
        // Check if it contains at least some meaningful words
        String[] commonReasons = {
            "ticket", "seat", "behavior", "conduct", "smoking", "drinking", "loud", "music", 
            "phone", "disturbing", "fighting", "argument", "rude", "inappropriate", "harassment",
            "littering", "damage", "property", "food", "smell", "hygiene", "overcrowding",
            "reservation", "berth", "compartment", "toilet", "cleanliness", "noise", "shouting"
        };
        
        String lowerReason = reason.toLowerCase();
        for (String word : commonReasons) {
            if (lowerReason.contains(word)) {
                return true;
            }
        }
        
        // If no common words found, check if it has meaningful structure (letters + spaces)
        return reason.matches(".*[a-zA-Z]{3,}.*") && reason.split("\\s+").length >= 2;
    }
    
    public static boolean isValidTrainNumber(String trainNo) {
        return trainNo != null && trainNo.matches("^\\d{5}$");
    }
    
    public static boolean isValidTrainName(String name) {
        return name != null && name.trim().length() >= 3 && name.matches(".*[a-zA-Z]{2,}.*");
    }
    
    public static boolean isValidStationName(String station) {
        if (station == null || station.trim().length() < 3) {
            return false;
        }
        if (!station.matches("^[a-zA-Z\\s]+$")) {
            return false;
        } 
        return station.matches(".*[a-zA-Z]{3,}.*");
    }
    public static boolean isValidDateTime(String dateTime) {
        if (dateTime == null) return false;
        return dateTime.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
    }  
    public static boolean isValidFare(String fare) {
        try {
            double amount = Double.parseDouble(fare);
            return amount > 0 && amount <= 50000; 
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidCoachCount(String count) {
        try {
            int num = Integer.parseInt(count);
            return num > 0 && num <= 100; 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
