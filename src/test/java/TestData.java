import bracketcove.testablecode.task.Task;
import bracketcove.testablecode.task.Tasks;

public class TestData {
    static final int TASK_ID = 123456;
    static final String TASK_NAME = "Work";
    static final String TASK_ICON = "work_icon.png";
    static final String TASK_COLOR = "DARK_BLUE";

    public static Task getTestTask() {
        return new Task(TASK_ID, TASK_NAME, TASK_ICON, TASK_COLOR);
    }

    public static Tasks getTestTasks() {
        return new Tasks(
                new Task[]{
                        getTestTask(),
                        getTestTask(),
                        getTestTask()
                }
        );
    }
}
