package se.ivankrizsan.spring.events;

import org.springframework.context.ApplicationEvent;

/**
 * An event type that contains a message and has a severity-level 1 to 10.
 * Instances of the event-type are immutable.
 *
 * @author Ivan Krizsan
 */
public class MultiLevelEvent extends ApplicationEvent {
    protected String mMessage;
    protected int mSeverityLevel;

    /**
     * Creates a new event instance.
     *
     * @param inSource Object from which event originates.
     * @param inMessage Message string to be passed on in the event.
     * @param inSeverityLevel Severity level, 1 to 10, to be set on the event.
     */
    public MultiLevelEvent(final Object inSource, final String inMessage, final int inSeverityLevel) {
        super(inSource);

        if (inSeverityLevel < 1 || inSeverityLevel > 10) {
            throw new IllegalArgumentException(("Severity level must be 1 to 10 inclusive"));
        }

        mMessage = inMessage;
        mSeverityLevel = inSeverityLevel;
    }

    public String getMessage() {
        return mMessage;
    }

    public int getSeverityLevel() {
        return mSeverityLevel;
    }
}
