package testablecode;

import bracketcove.testablecode.task.IManageTaskContract;
import bracketcove.testablecode.task.Task;

class FakeViewModel implements IManageTaskContract.ViewModel {
    private Task task = null;
    boolean setTaskCalled = false;
    boolean getTaskCalled = false;

    @Override
    public void setTask(Task task) {
        this.task = task;
        setTaskCalled = true;
    }

    @Override
    public Task getTask() {
        getTaskCalled = true;
        return task;
    }
}
