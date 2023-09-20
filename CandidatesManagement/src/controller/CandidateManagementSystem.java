package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.ExperienceCandidate;
import model.Candidate;
import model.FresherCandidate;
import model.InternCandidate;

public class CandidateManagementSystem {
    // ArrayList to store candidates
    private static ArrayList<Candidate> candidates = new ArrayList<>();
    private static int candidateIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program) ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createExperienceCandidate(scanner);
                    break;
                case 2:
                    createFresherCandidate(scanner);
                    break;
                case 3:
                    createInternCandidate(scanner);
                    break;
                case 4:
                    searchCandidates(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option (1-5).");
            }
        }
    }

    // Function to create an Experience candidate
    private static void createExperienceCandidate(Scanner scanner) {
        System.out.println("Creating Experience Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = ValidDate.getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = ValidDate.getValidPhone(scanner);
        String email = ValidDate.getValidEmail(scanner);
        int candidateType = 0; // Experience Candidate

        System.out.print("Enter Years of Experience: ");
        int expInYear = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Professional Skill: ");
        String proSkill = scanner.nextLine();

        ExperienceCandidate experienceCandidate = new ExperienceCandidate(
                candidateIdCounter++, firstName, lastName, birthDate, address, phone, email, candidateType,
                expInYear, proSkill);
        candidates.add(experienceCandidate);

        System.out.println("Experience Candidate created successfully.");
        displayCreatedCandidate(experienceCandidate);
    }

    // Function to create a Fresher candidate
    private static void createFresherCandidate(Scanner scanner) {
        System.out.println("Creating Fresher Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = ValidDate.getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = ValidDate.getValidPhone(scanner);
        String email = ValidDate.getValidEmail(scanner);
        int candidateType = 1; // Fresher Candidate

        System.out.print("Enter Graduation Date: ");
        String graduationDate = scanner.nextLine();
        System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
        String graduationRank = ValidDate.getValidGraduationRank(scanner);
        System.out.print("Enter University: ");
        String education = scanner.nextLine();

        FresherCandidate fresherCandidate = new FresherCandidate(
                candidateIdCounter++, firstName, lastName, birthDate, address, phone, email, candidateType,
                graduationDate, graduationRank, education);
        candidates.add(fresherCandidate);

        System.out.println("Fresher Candidate created successfully.");
        displayCreatedCandidate(fresherCandidate);
    }

    // Function to create an Intern candidate
    private static void createInternCandidate(Scanner scanner) {
        System.out.println("Creating Intern Candidate");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        String birthDate = ValidDate.getValidBirthDate(scanner);
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        String phone = ValidDate.getValidPhone(scanner);
        String email = ValidDate.getValidEmail(scanner);
        int candidateType = 2; // Intern Candidate

        System.out.print("Enter Majors: ");
        String majors = scanner.nextLine();
        System.out.print("Enter Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter University Name: ");
        String universityName = scanner.nextLine();

        InternCandidate internCandidate = new InternCandidate(
                candidateIdCounter++, firstName, lastName, birthDate, address, phone, email, candidateType,
                majors, semester, universityName);
        candidates.add(internCandidate);

        System.out.println("Intern Candidate created successfully.");
        displayCreatedCandidate(internCandidate);
    }

    // Function to search for candidates by name and type
    private static void searchCandidates(Scanner scanner) {
        System.out.println("Searching for Candidates");
        System.out.print("Enter Candidate name (First name or Last name): ");
        String searchName = scanner.nextLine();
        System.out.print("Enter type of candidate (0 for Experience, 1 for Fresher, 2 for Intern): ");
        int searchType = scanner.nextInt();

        System.out.println("The candidates found:");

        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().toLowerCase().contains(searchName.toLowerCase()) ||
                    candidate.getLastName().toLowerCase().contains(searchName.toLowerCase())) &&
                    candidate.getCandidateType() == searchType) {
                displayCreatedCandidate(candidate);
            }
        }
    }

    // Function to display the details of a created candidate
    private static void displayCreatedCandidate(Candidate candidate) {
        System.out.println("=============================");
        switch (candidate.getCandidateType()) {
            case 0:
                System.out.println("Experience Candidate:");
                break;
            case 1:
                System.out.println("Fresher Candidate:");
                break;
            case 2:
                System.out.println("Intern Candidate:");
                break;
        }
        candidate.displayCandidate();
        System.out.println("=============================");
    }

    
}
    