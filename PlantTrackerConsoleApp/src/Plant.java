public class Plant {
    //Private fields may need setters getters *****


    private int id;
    private String name;
    private String type;
    private String location;
    private String lastWateredDate;
    private String priority;
    private String notes;

    //contructor
    public Plant(int id, String name, String type, String location, String lastWateredDate, String priority, String notes){
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.lastWateredDate = lastWateredDate;
        this.priority = priority;
        this.notes = notes;
    }// end

    public int getId() {
        return id;
    }

    public String toCSV() {
        return id + "," + name + "," + type + "," + location + "," + lastWateredDate + "," + priority + "," + notes;
    }

    @Override
    public String toString() {
        return id + ". " + name + " (" + type + ") " + location +
                " | Last watered: " + lastWateredDate + " | Priority: " + priority + " | Notes: " + notes;
    }

}
