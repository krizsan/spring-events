package se.ivankrizsan.spring.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.ivankrizsan.spring.events.MultiLevelEvent;

/**
 * Event listener that listens to {@code MultiLevelEvent}s and handles separates events of low, mid and high
 * severity.
 *
 * @author Ivan Krizsan
 */
@Component
public class MultiLevelEventListener {
    /**
     * Handles the received {@link MultiLevelEvent} that has a severity level of 3 or less.
     *
     * @param inMultiLevelEvent Received event.
     */
    @EventListener(condition = "#inMultiLevelEvent.severityLevel <= 3")
    public void handleLowSeverityEvents(final MultiLevelEvent inMultiLevelEvent) {
        System.out.println("* A low-severity event was received: " + inMultiLevelEvent.getMessage()
        + ", severity level: " + inMultiLevelEvent.getSeverityLevel());
    }

    /**
     * Handles the received {@link MultiLevelEvent} that has a severity level in the range 3 to 6 inclusive.
     *
     * @param inMultiLevelEvent Received event.
     */
    @EventListener(condition = "#inMultiLevelEvent.severityLevel > 3 && #inMultiLevelEvent.severityLevel <= 6")
    public void handleMidSeverityEvents(final MultiLevelEvent inMultiLevelEvent) {
        System.out.println("** A mid-severity event was received: " + inMultiLevelEvent.getMessage()
            + ", severity level: " + inMultiLevelEvent.getSeverityLevel());
    }

    /**
     * Handles the received {@link MultiLevelEvent} that has a severity level above 6.
     *
     * @param inMultiLevelEvent Received event.
     */
    @EventListener(condition = "#inMultiLevelEvent.severityLevel > 6")
    public void handleHighSeverityEvents(final MultiLevelEvent inMultiLevelEvent) {
        System.out.println("*** A high-severity event was received: " + inMultiLevelEvent.getMessage()
            + ", severity level: " + inMultiLevelEvent.getSeverityLevel());
    }
}
