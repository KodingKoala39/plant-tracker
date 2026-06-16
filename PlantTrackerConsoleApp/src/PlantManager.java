import java.io.*;
import java.util.ArrayList;

public class PlantManager {

    //class data
    private ArrayList<Plant> plants;
    private final String FILE_NAME = "plants.csv";

    public PlantManager()  {
        plants = new ArrayList<>();
        loadPlants();
    }

    public void loadPlants() {

        File file = new File(FILE_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Created new plants.csv file.");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String type = data[2];
                String location = data[3];
                String lastWateredDate = data[4];
                String priority = data[5];
                String notes = data[6];

                Plant plant = new Plant (id, name, type, location, lastWateredDate,
                        priority,notes);

                plants.add(plant);


            }

            reader.close();


        } catch (Exception e) {
            System.out.println("Error loading plants file.");
            e.printStackTrace();
        }

    }


    public void savedPlants () {

        try {
            BufferedWriter writer = new BufferedWriter((new FileWriter(FILE_NAME)));

            for (Plant plant : plants){
                writer.write(plant.toCSV());
                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void addPlant (Plant plant) {
        plants.add(plant);
        savedPlants();
    }

    public void viewPlants() {
        if (plants.isEmpty()) {
            System.out.println("No plants found");
            return;
        }

        for (Plant plant : plants){
            System.out.println(plant);
        }

    }

    public int getNextID() {
        int maxId = 0;

        for (Plant plant : plants){
            if (plant.getId() > maxId) {
                maxId = plant.getId();
            }
        }

        return maxId + 1;

    }

    public int getNextId() {
        int maxId = 0;

        for (Plant plant : plants) {
            if (plant.getId() > maxId) {
                maxId = plant.getId();
            }
        }

        return maxId + 1;
    }




}
