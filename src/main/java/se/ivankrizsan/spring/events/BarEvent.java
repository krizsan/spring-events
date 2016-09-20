package se.ivankrizsan.spring.events;

import org.springframework.context.ApplicationEvent;

/**
 * Bar type event.
 * Instances of the event-type are immutable.
 *
 * @author Ivan Krizsan
 */
public class BarEvent extends ApplicationEvent {
    protected String mBarMessage;

    /**
     * Creates a new event instance.
     *
     * @param inSource Object from which event originates.
     * @param inBarMessage Message string to be passed on in the event.
     */
    public BarEvent(final Object inSource, final String inBarMessage) {
        super(inSource);
        mBarMessage = inBarMessage;
    }

    public String getBarMessage() {
        return mBarMessage;
    }
}
