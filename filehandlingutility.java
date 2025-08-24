import java.io.*;
import java.util.Scanner;


public class FileHandlingUtility {

    // Method to write content into a file
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------\n");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    // Method to append new content into a file (modify)
    public static void appendToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine(); // Add new line before appending
            writer.write(content);
            System.out.println("Content appended successfully!");
        } catch (IOException e) {
            System.out.println("Error while appending to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String fileName = "sample.txt";

        System.out.println("File Handling Utility");
        System.out.println("1. Write to File");
        System.out.println("2. Read File");
        System.out.println("3. Append to File");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter content to write:");
                String content = sc.nextLine();
                writeFile(fileName, content);
                break;

            case 2:
                readFile(fileName);
                break;

            case 3:
                System.out.println("Enter content to append:");
                String appendContent = sc.nextLine();
                appendToFile(fileName, appendContent);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
