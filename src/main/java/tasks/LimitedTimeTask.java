package tasks;

import java.time.LocalDateTime;

public class LimitedTimeTask extends Task{
    private LocalDateTime deadline;

    public LimitedTimeTask(String name, String description, String creator, LocalDateTime deadline) {
        super(name, description, creator);
        this.deadline = deadline;
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Creator: " + getCreator() + ", Deadline: " + deadline.toString();
    }

    // გეტერი და სეტერი deadline-ისთვის
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
