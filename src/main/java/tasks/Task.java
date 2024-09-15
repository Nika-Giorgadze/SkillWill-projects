package tasks;

public abstract class Task {
    private String name;
    private String description;
    private String creator;

    public Task(String name, String description, String creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    // გეტერები და სეტერები
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {

        this.creator = creator;
    }

    // მეთოდი, რომლითაც ვაწვდით ინფორმაციას ტასკზე
    public abstract String getDetails();
}
