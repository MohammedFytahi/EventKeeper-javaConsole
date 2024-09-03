import java.util.ArrayList;
import java.util.List;

class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private String type;

    public Event(int id, String name, String date, String location, String type) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.type = type;
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Event [ID=" + id + ", Name=" + name + ", Date=" + date + ", Location=" + location + ", Type=" + type + "]";
    }
}


