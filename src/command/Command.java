package command;

import java.util.Objects;

public enum Command {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),
    MARK_IN_PROGRESS("mark-in-progress"),
    MARK_DONE("mark-done"),
    LIST("list"),
    EXIT("exit");
    private final String s;
    Command(String s){
        this.s = s;
    }
    public boolean isEqual(String s){
        return this.s.equals(s);
    }
}
