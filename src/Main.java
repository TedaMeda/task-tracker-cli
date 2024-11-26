import command.CommandLineParser;
import todo.TodoManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("task-tracker>>  ");
            CommandLineParser cp = new CommandLineParser(sc.nextLine());
            List<String> ls = cp.getArgs();
            TodoManager manager = new TodoManager(ls);
            manager.execute();
        }
    }
}