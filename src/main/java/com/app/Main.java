package com.app;

import com.entities.Trainer;
import com.service.TrainerService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final TrainerService trainerService = new TrainerService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Trainer Management =====");
            System.out.println("1. Add Trainer");
            System.out.println("2. Search Trainer");
            System.out.println("3. Update Trainer");
            System.out.println("4. Delete Trainer");
            System.out.println("5. View All Trainers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    addTrainer();
                    break;
                case 2:
                    searchTrainer();
                    break;
                case 3:
                    updateTrainer();
                    break;
                case 4:
                    deleteTrainer();
                    break;
                case 5:
                    viewAllTrainers();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addTrainer() {
        Trainer trainer = new Trainer();
        System.out.print("Enter Trainer Name: ");
        trainer.setName(scanner.nextLine().trim());

        System.out.print("Enter Technology (comma separated): ");
        List<String> technology = Arrays.asList(scanner.nextLine().split(","));
        trainer.setTechnology(technology);

        System.out.print("Enter Experience (years): ");
        trainer.setExperience(readInt());

        System.out.print("Enter Email: ");
        trainer.setEmail(scanner.nextLine().trim());

        System.out.print("Enter Mobile: ");
        trainer.setMobile(scanner.nextLine().trim());

        Trainer saved = trainerService.registerTrainer(trainer);
        System.out.println("Trainer added successfully: " + saved);
    }

    private static void searchTrainer() {
        System.out.print("Enter Trainer Id: ");
        Long id = readLong();
        Trainer trainer = trainerService.searchTrainer(id);
        if (trainer != null) {
            System.out.println(trainer);
        } else {
            System.out.println("No trainer found with Id: " + id);
        }
    }

    private static void updateTrainer() {
        System.out.print("Enter Trainer Id to update: ");
        Long id = readLong();
        Trainer trainer = trainerService.searchTrainer(id);
        if (trainer == null) {
            System.out.println("No trainer found with Id: " + id);
            return;
        }

        System.out.print("Enter Trainer Name: ");
        trainer.setName(scanner.nextLine().trim());

        System.out.print("Enter Technology (comma separated): ");
        List<String> technology = Arrays.asList(scanner.nextLine().split(","));
        trainer.setTechnology(technology);

        System.out.print("Enter Experience (years): ");
        trainer.setExperience(readInt());

        System.out.print("Enter Email: ");
        trainer.setEmail(scanner.nextLine().trim());

        System.out.print("Enter Mobile: ");
        trainer.setMobile(scanner.nextLine().trim());

        trainerService.updateTrainer(trainer);
        System.out.println("Trainer updated successfully.");
    }

    private static void deleteTrainer() {
        System.out.print("Enter Trainer Id to delete: ");
        Long id = readLong();
        trainerService.deleteTrainer(id);
        System.out.println("Trainer deleted (if existed) with Id: " + id);
    }

    private static void viewAllTrainers() {
        List<Trainer> trainers = trainerService.displayAll();
        if (trainers == null || trainers.isEmpty()) {
            System.out.println("No trainers found.");
            return;
        }
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter again: ");
            }
        }
    }

    private static Long readLong() {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter again: ");
            }
        }
    }
}
