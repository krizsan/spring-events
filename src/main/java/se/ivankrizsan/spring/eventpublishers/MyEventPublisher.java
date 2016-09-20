package se.ivankrizsan.spring.eventpublishers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.ivankrizsan.spring.events.BarEvent;
import se.ivankrizsan.spring.events.FooEvent;
import se.ivankrizsan.spring.events.MultiLevelEvent;

import java.util.Date;


/**
 * Spring component that publishes different types of events at different intervals.
 * Note that the events are published synchronously and the call to the publishEvent method
 * will not return until the event has been processed by all listeners.
 *
 * @author Ivan Krizsan
 */
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {
    protected ApplicationEventPublisher mApplicationEventPublisher;

    /**
     * Publishes {@link FooEvent}s at regular interval.
     */
    @Scheduled(fixedRate = 4000L)
    public void publishFooEvents() {
        final Date theDate = new Date();
        final FooEvent theFooEvent = new FooEvent(this, "Foo event sent at: " + theDate.toString());

        System.out.println("MyEventPublisher - Before publishing FooEvent");
        mApplicationEventPublisher.publishEvent(theFooEvent);
        System.out.println("MyEventPublisher - After publishing FooEvent");
    }

    /**
     * Publishes {@link BarEvent}s at regular interval.
     */
    @Scheduled(fixedRate = 3000L)
    public void publishBarEvents() {
        final Date theDate = new Date();
        final BarEvent theBarEvent = new BarEvent(this, "Bar event sent at: " + theDate.toString());

        System.out.println("MyEventPublisher - Before publishing BarEvent");
        mApplicationEventPublisher.publishEvent(theBarEvent);
        System.out.println("MyEventPublisher - After publishing BarEvent");
    }

    /**
     * Publishes {@link MultiLevelEvent}s with random severity levels at regular interval.
     */
    @Scheduled(fixedRate = 2000L)
    public void publishMultiLevelEvents() {
        final Date theDate = new Date();
        final int theSeverityLevel = (int) (Math.random() * 10 + 1);
        final MultiLevelEvent theMultiLevelEvent = new MultiLevelEvent(this, "Multi-level event at: "
            + theDate.toString(), theSeverityLevel);

        System.out.println("MyEventPublisher - Before publishing MultiLevelEvent");
        mApplicationEventPublisher.publishEvent(theMultiLevelEvent);
        System.out.println("MyEventPublisher - After publishing MultiLevelEvent");
    }

    @Override
    public void setApplicationEventPublisher(final ApplicationEventPublisher inApplicationEventPublisher) {
        mApplicationEventPublisher = inApplicationEventPublisher;
    }
}
