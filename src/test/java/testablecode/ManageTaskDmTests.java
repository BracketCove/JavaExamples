package testablecode;

import bracketcove.testablecode.task.ManageTaskDecisionMaker;
import bracketcove.testablecode.task.ManageTaskEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageTaskDmTests {
    private FakeView view;
    private FakeViewModel vm;
    private FakeTaskStorage storage;
    private ManageTaskDecisionMaker dm;

    @BeforeEach
    void setUp(){
        view = new FakeView();
        vm = new FakeViewModel();
        vm.setTask(TestData.getTestTask());
        vm.setTaskCalled = false;
        storage = new FakeTaskStorage();
        dm = new ManageTaskDecisionMaker(view, vm, storage);
    }

    @Test
    public void onColorSelected() {
        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_COLOR_SELECTED,
                TestData.TASK_COLOR
        );

        dm.onViewEvent(event);

        assertTrue(view.setButtonColorCalled);
        assertTrue(vm.setTaskCalled);
    }

    @Test
    public void onDoneClickSuccess() {
        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_DONE_CLICK,
                ""
        );

        dm.onViewEvent(event);

        assertTrue (view.getNameCalled);
        assertTrue (vm.getTaskCalled);
        assertTrue (view.goToTaskListScreenCalled);
    }

    @Test
    public void onDoneClickException() {
        storage.setWillFail(true);

        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_DONE_CLICK,
                ""
        );


        dm.onViewEvent(event);

        assertTrue (view.getNameCalled);
        assertTrue (vm.getTaskCalled);
        assertTrue (view.showMessageCalled);
        assertTrue (view.goToTaskListScreenCalled);
    }

    @Test
    public void onIconSelected() {
        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_ICON_SELECTED,
                TestData.TASK_ICON
        );

        dm.onViewEvent(event);

        assertTrue (vm.getTaskCalled);
        assertTrue (vm.setTaskCalled);
        assertTrue (view.setIconCalled);
    }

    @Test
    public void onStartSuccess() {
        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_START,
                0
        );

        dm.onViewEvent(event);

        assertTrue (vm.setTaskCalled);
        assertTrue (vm.getTaskCalled);
        assertTrue (view.setButtonColorCalled);
        assertTrue (view.setNameCalled);
        assertTrue (view.setIconCalled);
    }

    @Test
    public void onStartException() {
        storage.setWillFail(true);

        ManageTaskEvent event = new ManageTaskEvent(
                ManageTaskEvent.Event.ON_START,
                ""
        );

        dm.onViewEvent(event);

        assertTrue (vm.getTaskCalled);
        assertTrue (view.showMessageCalled);
        assertTrue (view.goToTaskListScreenCalled);
    }
}