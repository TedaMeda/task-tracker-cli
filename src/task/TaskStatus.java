package task;

public enum TaskStatus {
    TODO("todo"),
    DONE("done"),
    IN_PROGRESS("in-progress");
    private final String s;
    TaskStatus(String s) {
        this.s = s;
    }
    public boolean isEqual(String s){
        return this.s.equals(s);
    }
    public String getS() {
        return this.s;
    }
    public static TaskStatus getValueOf(String status){
        for(TaskStatus taskStatus: TaskStatus.values()){
            if(taskStatus.isEqual(status)){
                return taskStatus;
            }
        }
        return null;
    }
}
