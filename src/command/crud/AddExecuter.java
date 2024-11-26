package command.crud;

import command.CommandExecuter;
import fileSystem.FileUtils;
import json.JsonUtil;
import task.Task;
import util.Commans;

import java.io.IOException;
import java.util.List;

public class AddExecuter implements CommandExecuter {
    private String s;

    public AddExecuter(String s) {
        this.s = s;
    }

    @Override
    public void executeCommand() {
        Task task = new Task(s);
        try {
            String currentFile = FileUtils.readFile(Commans.FILE_NAME);
            List<Task> list = JsonUtil.toTaskList(currentFile);
            list.add(task);
            String json = JsonUtil.toJsonArray(list);
            FileUtils.writeFile(Commans.FILE_NAME, json);
        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}
