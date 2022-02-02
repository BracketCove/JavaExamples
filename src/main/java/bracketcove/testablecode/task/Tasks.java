package bracketcove.testablecode.task;

public class Tasks {
    private final Task[] tasks;

    public Tasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public Task[] get() {
        return tasks;
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) return task;
        }

        return null;
    }
}
