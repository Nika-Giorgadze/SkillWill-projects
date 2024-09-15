package tasks;

public class BasicTask extends Task{
    public BasicTask(String name, String description, String creator) {
        super(name, description, creator);
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Creator: " + getCreator();
    }
}
