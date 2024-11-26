package todo;

import command.CommandExecuter;
import command.crud.*;
import command.Command;
import util.StringUtils;

import java.util.List;

public class TodoManager {
    private List<String> args;

    public TodoManager(List<String> args) {
        this.args = args;
    }

    public void execute() {
        if(!args.isEmpty()){
            String firstCommand = StringUtils.toLower(args.get(0));
            CommandExecuter commandExecuter=null;
            try {
                if(Command.ADD.isEqual(firstCommand)){
                    commandExecuter = new AddExecuter(args.get(1));
                }
                else if(Command.UPDATE.isEqual(firstCommand)){
                    commandExecuter = new UpdateTaskExecuter(Integer.parseInt(args.get(1)), args.get(2));
                }
                else if(Command.DELETE.isEqual(firstCommand)){
                    commandExecuter = new DeleteExecuter(Integer.parseInt(args.get(1)));
                }
                else if(Command.MARK_DONE.isEqual(firstCommand) || Command.MARK_IN_PROGRESS.isEqual(firstCommand)){
                    commandExecuter = new UpdateTaskStatusExecuter(Integer.parseInt(args.get(1)), firstCommand);
                }
                else if(Command.LIST.isEqual(firstCommand)){
                    if(args.size()>1) commandExecuter = new ListExecuter(args.get(1));
                    else commandExecuter = new ListExecuter(null);
                }
                else if(Command.EXIT.isEqual(firstCommand)){
                    System.exit(0);
                }
                else if("help".equals(StringUtils.toLower(firstCommand))){
                    System.out.println("add \"<task-name>\"");
                    System.out.println("update <task-id>");
                    System.out.println("mark-done <task-id>");
                    System.out.println("mark-todo <task-id>");
                    System.out.println("mark-in-progress <task-id>");
                    System.out.println("delete <task-id>");
                    System.out.println("list");
                    System.out.println("list todo");
                    System.out.println("list in-progress");
                    System.out.println("list done");
                }
                else{
                    System.out.println("Enter valid command");
                    return;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Too less arguments");
            }
            catch (NumberFormatException e){
                System.out.println("Enter valid id");
            }

            if(commandExecuter!=null)commandExecuter.executeCommand();
        }
    }
}
