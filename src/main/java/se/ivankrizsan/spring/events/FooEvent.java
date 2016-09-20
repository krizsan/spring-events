package se.ivankrizsan.spring.events;

import org.springframework.context.ApplicationEvent;

/**
 * Foo type event.
 * Instances of the event-type are immutable.
 *
 * @author Ivan Krizsan
 */
public class FooEvent extends ApplicationEvent {
    protected String mFooMessage;

    /**
     * Creates a new event instance.
     *
     * @param inSource Object from which event originates.
     * @param inFooMessage Message string to be passed on in the event.
     */
    public FooEvent(final Object inSource, final String inFooMessage) {
        super(inSource);
        mFooMessage = inFooMessage;
    }

    public String getFooMessage() {
        return mFooMessage;
    }
}
