import bracketcove.testablecode.task.IManageTaskContract;

class FakeView implements IManageTaskContract.View {

    boolean setNameCalled = false;
    boolean getNameCalled = false;
    boolean setIconCalled = false;
    boolean setButtonColorCalled = false;
    boolean goToTaskListScreenCalled = false;
    boolean showMessageCalled = false;

    @Override
    public void setName(String name) {
        setNameCalled = true;
    }

    @Override
    public String getName() {
        getNameCalled = true;
        return "Lorem Ipsum";
    }

    @Override
    public void setIcon(String icon) {
        setIconCalled = true;
    }

    @Override
    public void setColor(String c) {
        setButtonColorCalled = true;
    }

    @Override
    public void goToTaskListScreen() {
        goToTaskListScreenCalled = true;
    }

    @Override
    public void showMessage(String message) {
        showMessageCalled = true;
    }
}