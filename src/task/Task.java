package task;

import util.Commans;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String name;
    private TaskStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Task() {
    }

    public Task(String name) {
        this.id = Commans.getId();
        this.name = name;
        this.status = TaskStatus.TODO;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
