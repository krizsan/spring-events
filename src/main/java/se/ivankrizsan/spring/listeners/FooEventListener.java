package se.ivankrizsan.spring.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.ivankrizsan.spring.events.FooEvent;

/**
 * Event listener that listens to {@code FooEvent}s.
 *
 * @author Ivan Krizsan
 */
@Component
public class FooEventListener {
    /**
     * Handles the received {@link FooEvent}.
     *
     * @param inFooEvent Received event.
     */
    @EventListener
    public void handleFooEvents(final FooEvent inFooEvent) {
        System.out.println("FooEventListener received a FooEvent with the message: " + inFooEvent.getFooMessage());
    }
}
