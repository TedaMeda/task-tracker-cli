package command.crud;

import command.CommandExecuter;
import task.TaskStatus;

public abstract class UpdateExecuter implements CommandExecuter {
    protected Integer id;
    protected String task;
    protected TaskStatus status;

    public UpdateExecuter(Integer id, TaskStatus status, String task) {
        this.id = id;
        this.status = status;
        this.task = task;
    }
}
