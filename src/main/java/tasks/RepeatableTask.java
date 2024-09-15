package tasks;

import java.time.LocalDateTime;

public class RepeatableTask extends Task{
    private int repeatCount;
    private LocalDateTime repeatInterval;

    public RepeatableTask(String name, String description, String creator, int repeatCount, LocalDateTime repeatInterval) {
        super(name, description, creator);
        this.repeatCount = repeatCount;
        this.repeatInterval = repeatInterval;
    }

    @Override
    public String getDetails() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Creator: " + getCreator() + ", Repeat Count: " + repeatCount + ", Repeat Interval: " + repeatInterval.toString();
    }

    // გეტერები და სეტერები
    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public LocalDateTime getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(LocalDateTime repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
}
