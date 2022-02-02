package bracketcove.testablecode.task;

public class Task {
    private final int taskId;
    private final String taskName;

    //these things need to be translated into Resource Ids
    private final String taskIcon;
    private final String taskColor;

    public Task(int taskId, String taskName, String taskIcon, String taskColor) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskIcon = taskIcon;
        this.taskColor = taskColor;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskIcon() {
        return taskIcon;
    }

    public String getTaskColor() {
        return taskColor;
    }
}