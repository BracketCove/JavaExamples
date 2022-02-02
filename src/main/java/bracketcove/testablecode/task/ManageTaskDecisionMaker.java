package bracketcove.testablecode.task;


public class ManageTaskDecisionMaker {
    private IManageTaskContract.View view;
    private IManageTaskContract.ViewModel vm;
    private ITaskStorage storage;

    public ManageTaskDecisionMaker(IManageTaskContract.View view,
                                   IManageTaskContract.ViewModel vm,
                                   ITaskStorage storage) {
        this.view = view;
        this.vm = vm;
        this.storage = storage;
    }

    public void onViewEvent(ManageTaskEvent event) {
        switch (event.getEvent()) {
            case ON_START:
                onStart();
                break;
            case ON_COLOR_SELECTED:
                onColorSelected((String) event.getValue());
                break;
            case ON_DONE_CLICK:
                updateStorage();
                break;
            case ON_ICON_SELECTED:
                onIconSelected((String) event.getValue());
                break;
        }
    }


    private void onStart() {
        storage.getTask(vm.getTask().getTaskId(), new Continuation<Task>() {
            @Override
            public void onSuccess(Task result) {
                vm.setTask(result);
                view.setColor(result.getTaskColor());
                view.setName(result.getTaskName());
                view.setIcon(result.getTaskIcon());
            }

            @Override
            public void onException(Exception e) {
                view.showMessage(e.getMessage());
                view.goToTaskListScreen();
            }
        });
    }

    private void onIconSelected(String icon) {
        Task oldTask = vm.getTask();
        Task update = new Task(
                oldTask.getTaskId(),
                oldTask.getTaskName(),
                icon,
                oldTask.getTaskColor()
        );

        vm.setTask(update);
        view.setIcon(update.getTaskIcon());
    }

    private void updateStorage() {
        Task oldTask = vm.getTask();
        Task update = new Task(
                oldTask.getTaskId(),
                view.getName(),
                oldTask.getTaskIcon(),
                oldTask.getTaskColor()
        );

        storage.updateTask(update, new Continuation<Void>() {
            @Override
            public void onSuccess(Void result) {
                view.goToTaskListScreen();
            }

            @Override
            public void onException(Exception e) {
                view.showMessage(e.getMessage());
                view.goToTaskListScreen();
            }
        });
    }

    private void onColorSelected(String color) {
        Task oldTask = vm.getTask();
        Task newTask = new Task(
                oldTask.getTaskId(),
                oldTask.getTaskName(),
                oldTask.getTaskIcon(),
                color
        );
        vm.setTask(newTask);
        view.setColor(newTask.getTaskColor());
    }
}
