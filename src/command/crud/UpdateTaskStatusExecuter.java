package command.crud;

import fileSystem.FileUtils;
import json.JsonUtil;
import task.Task;
import task.TaskStatus;
import util.Commans;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UpdateTaskStatusExecuter extends UpdateExecuter{
    public UpdateTaskStatusExecuter(Integer id, String status) {
        super(id, TaskStatus.getValueOf(status), null);
    }

    @Override
    public void executeCommand() {
        try {
            String currentFile = FileUtils.readFile(Commans.FILE_NAME);
            List<Task> list = JsonUtil.toTaskList(currentFile);
            for (int i = 0; i < list.size(); i++) {
                Task task = list.get(i);
                if(Objects.equals(task.getId(), this.id)){
                    task.setStatus(this.status);
                    task.setUpdatedDate(LocalDateTime.now());
                    break;
                }
            }
            String json = JsonUtil.toJsonArray(list);
            FileUtils.writeFile(Commans.FILE_NAME, json);
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}
