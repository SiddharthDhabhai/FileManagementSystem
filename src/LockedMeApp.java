import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeApp {
    private static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) {
        displayWelcomeScreen();
        handleUserInteractions();
    }

    private static void displayWelcomeScreen() {
        System.out.println("=================================");
        System.out.println("        LockedMe PVT. LTD.");
        System.out.println("    Developer: Siddharth Dhabhai");
        System.out.println("=================================");
    }

    private static void handleUserInteractions() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            displayOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the input

            switch (choice) {
                case 1:
                    retrieveFileNames();
                    break;
                case 2:
                    manageFiles(scanner);
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayOptions() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Retrieve file names");
        System.out.println("2. File operations");
        System.out.println("3. Close the application");
        System.out.print("Enter your choice: ");
    }

    private static void retrieveFileNames() {
        if (fileNames.isEmpty()) {
            System.out.println("No files found in the directory.");
        } else {
            Collections.sort(fileNames);
            System.out.println("File names in ascending order:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }
    }

    private static void manageFiles(Scanner scanner) {
        boolean isRunning = true;

        while (isRunning) {
            displayFileOperations();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the input

            switch (choice) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayFileOperations() {
        System.out.println("\n--- File Operations ---");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Navigate back to the main menu");
        System.out.print("Enter your choice: ");
    }

    private static void addFile(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        fileNames.add(fileName);
        System.out.println("File added successfully.");
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();
        if (fileNames.remove(fileName)) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();
        if (fileNames.contains(fileName)) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
    }
}
