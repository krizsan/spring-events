package se.ivankrizsan.spring.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Event listener that listens to all events within the application.
 *
 * @author Ivan Krizsan
 */
@Component
public class AllEventsListener {
    /**
     * Handles received event.
     *
     * @param inEvent Received event.
     */
    @EventListener
    public void handleEvent(final Object inEvent) {
        System.out.println("- AllEventsListener received event: " + inEvent);
    }
}
