package bracketcove.testablecode.task;

public interface IManageTaskContract {
    interface View {
        void setName(String name);
        String getName();
        void setIcon(String icon);
        void setColor(String c);
        void goToTaskListScreen();
        void showMessage(String message);
    }

    interface ViewModel {
        void setTask(Task task);
        Task getTask();
    }
}
