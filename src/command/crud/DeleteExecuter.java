package command.crud;

import command.CommandExecuter;
import fileSystem.FileUtils;
import json.JsonUtil;
import task.Task;
import util.Commans;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DeleteExecuter implements CommandExecuter {
    private Integer id;

    public DeleteExecuter(Integer id) {
        this.id = id;
    }

    @Override
    public void executeCommand() {
        try {
            String currentFile = FileUtils.readFile(Commans.FILE_NAME);
            List<Task> list = JsonUtil.toTaskList(currentFile);
            for (int i = 0; i < list.size(); i++) {
                Task task = list.get(i);
                if(Objects.equals(task.getId(), this.id)){
                    list.remove(i);
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
