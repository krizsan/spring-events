package se.ivankrizsan.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main entry-point for the Spring events demo application.
 *
 * @author Ivan Krizsan
 */
@SpringBootApplication
@EnableScheduling
public class SpringEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventsApplication.class, args);

        /* Wait in order for events to be published and received. */
        try {
            Thread.sleep(10000L);
        } catch (final InterruptedException theException) {
        }
    }
}
