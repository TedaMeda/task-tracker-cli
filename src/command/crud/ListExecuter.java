package command.crud;

import command.CommandExecuter;
import fileSystem.FileUtils;
import json.JsonUtil;
import task.Task;
import task.TaskStatus;
import util.Commans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListExecuter implements CommandExecuter {
    private TaskStatus taskStatus=null;

    public ListExecuter(){}
    public ListExecuter(String taskStatus) {
        this.taskStatus = TaskStatus.getValueOf(taskStatus);
    }

    @Override
    public void executeCommand() {
        String jsonFile = FileUtils.readFile(Commans.FILE_NAME);
        List<Task> tasks = JsonUtil.toTaskList(jsonFile);
        List<Task> todo = new ArrayList<>(), inProgress=new ArrayList<>(), done=new ArrayList<>();
        for (Task task: tasks){
            if(task.getStatus() == TaskStatus.TODO) todo.add(task);
            if(task.getStatus() == TaskStatus.IN_PROGRESS) inProgress.add(task);
            if (task.getStatus() == TaskStatus.DONE) done.add(task);
        }

        if(this.taskStatus==null){
            printList(todo, "PENDING TASKS");
            printList(inProgress, "IN-PROGRESS TASKS");
            printList(done, "DONE TASKS");
        }
        else if(this.taskStatus==TaskStatus.TODO){
            printList(todo, "PENDING TASKS");
        }
        else if(this.taskStatus==TaskStatus.IN_PROGRESS){
            printList(inProgress, "IN-PROGRESS TASKS");
        }
        else if(this.taskStatus==TaskStatus.DONE){
            printList(done, "DONE TASKS");
        }
    }
    private void printList(List<Task> tasks, String msg){
        System.out.println("============="+msg+"=============");
        for (Task task: tasks){
            System.out.printf("%s, %s, %s\n",task.getId(), task.getName(), task.getCreatedDate());
        }
        System.out.println("\n\n");
    }
}
