package bracketcove.testablecode.task;

public class ManageTaskEvent {
    private final Event event;
    private final Object value;

    public ManageTaskEvent(Event event, Object value){
        this.event = event;
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }
    public Object getValue() {
        return value;
    }

    public enum Event { ON_COLOR_SELECTED, ON_DONE_CLICK, ON_ICON_SELECTED, ON_START }
}
