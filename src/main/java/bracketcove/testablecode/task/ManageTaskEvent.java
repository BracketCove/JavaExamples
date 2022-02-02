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

    /**
     * NOTE: ON_START expects a taskID to be sent in as the value
     */
    public enum Event {
        ON_COLOR_SELECTED,
        ON_DONE_CLICK,
        ON_ICON_SELECTED,
        ON_START
    }
}
