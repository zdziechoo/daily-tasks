package pl.com.tt.dailytasks.Entity;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String name;
    private String description;
    private Urgency urgency;
    private LocalDateTime createStamp;

    public Task(){}

    public Task(int id, String name, String description, Urgency urgency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urgency = urgency;
        setNowCreateStamp();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(LocalDateTime localDateTime) {
        this.createStamp = localDateTime;
    }
    public void setNowCreateStamp(){
        LocalDateTime now = LocalDateTime.now();
        this.createStamp = now;
    }
}
