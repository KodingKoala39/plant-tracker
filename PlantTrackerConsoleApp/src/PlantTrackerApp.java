import java.sql.SQLOutput;
import java.util.Scanner;

public class PlantTrackerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PlantManager manager = new PlantManager();

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n== Plant Tracker ===" +
                    "\nAuthor: Andy Sanchez" +
                    "\nVersion 1.0");

            System.out.println("1. Add Plant" +
                    "\n2. View Plants" +
                    "\n3. Save and Exit");

            System.out.println("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clears leftover new line

            switch (choice){
                case 1:
                    System.out.print("Plant name: ");
                    String name = scanner.nextLine();

                    System.out.print("Plant type: ");
                    String type = scanner.nextLine();

                    System.out.print("Location: ");
                    String location = scanner.nextLine();

                    System.out.print("Last watered date: ");
                    String lastWateredDate = scanner.nextLine();

                    System.out.print("Priority: ");
                    String priority = scanner.nextLine();

                    System.out.print("Notes: ");
                    String notes = scanner.nextLine();

                    int id = manager.getNextId();

                    Plant newPlant = new Plant(
                            id,
                            name,
                            type,
                            location,
                            lastWateredDate,
                            priority,
                            notes
                    );

                    manager.addPlant(newPlant);
                    System.out.println("Plant added.");
                    break;

                case 2:
                    manager.viewPlants();
                    break;

                case 3:
                    manager.savedPlants();
                    System.out.println("Plants saved, Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");

            }// end switch


        }// end while

        scanner.close();

        /* FIX ME - delete me
        Plant Monstera = new Plant(001, "monty", "Monstera Deliciosa", "Living Room"
        , "06/07/2025", "High", "Signs of Fungus rust- must take action");
        */




    }// end main


}// end class
