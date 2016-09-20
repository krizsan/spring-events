package se.ivankrizsan.spring.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.ivankrizsan.spring.events.BarEvent;
import se.ivankrizsan.spring.events.FooEvent;

/**
 * Event listener that listens to {@code FooEvent}s and {@code BarEvent}s.
 *
 * @author Ivan Krizsan
 */
@Component
public class FooBarEventListener {
    /**
     * Handles the received {@link FooEvent}.
     *
     * @param inFooEvent Received event.
     */
    @EventListener
    public void handleFooEvents(final FooEvent inFooEvent) {
        System.out.println("FooBarEventListener received a FooEvent with the message: " + inFooEvent.getFooMessage());
    }

    /**
     * Handles the received {@link BarEvent}.
     *
     * @param inBarEvent Received event.
     */
    @EventListener({BarEvent.class})
    public void handleBarEvents(final BarEvent inBarEvent) {
        System.out.println("FooBarEventListener received a BarEvent with the message: " + inBarEvent.getBarMessage());
    }
}
