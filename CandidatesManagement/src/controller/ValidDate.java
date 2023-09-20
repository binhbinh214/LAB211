package controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidDate {
    // Function to get a valid birth date in the format (1900..Current Year)
    
    public static String getValidBirthDate(Scanner scanner) {
    String birthDatePattern = "^(19[0-9][0-9]|20[0-9][0-9])$";
    String birthDate;

    while (true) {
        System.out.print("Enter Birth Date (YYYY): ");
        birthDate = scanner.nextLine();

        Pattern pattern = Pattern.compile(birthDatePattern);
        Matcher matcher = pattern.matcher(birthDate);

        if (matcher.matches()) {
            break;
        } else {
            System.out.println("Invalid birth date format. Please enter a valid year (YYYY).");
        }
    }

    return birthDate;
}


    // Function to get a valid phone number with minimum 10 characters
    public static String getValidPhone(Scanner scanner) {
        String phonePattern = "^[0-9]{10,}$";
        String phone;

        while (true) {
            System.out.print("Enter Phone Number (at least 10 digits): ");
            phone = scanner.nextLine();

            Pattern pattern = Pattern.compile(phonePattern);
            Matcher matcher = pattern.matcher(phone);

            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Invalid phone number format. Please enter at least 10 digits.");
            }
        }

        return phone;
    }

    // Function to get a valid email address
    public static String getValidEmail(Scanner scanner) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        String email;

        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();

            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        }

        return email;
    }

    // Function to get a valid graduation rank (Excellence/Good/Fair/Poor)
    public static String getValidGraduationRank(Scanner scanner) {
        String[] validRanks = {"Excellence", "Good", "Fair", "Poor"};
        String graduationRank;

        while (true) {
            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            graduationRank = scanner.nextLine();

            boolean isValid = false;
            for (String rank : validRanks) {
                if (graduationRank.equalsIgnoreCase(rank)) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                break;
            } else {
                System.out.println("Invalid graduation rank. Please enter one of the following: Excellence/Good/Fair/Poor.");
            }
        }

        return graduationRank;
    }
}
    

