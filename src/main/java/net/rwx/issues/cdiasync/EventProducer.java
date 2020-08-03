/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rwx.issues.cdiasync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author mlvtito
 */
@ApplicationScoped
public class EventProducer {
    
    private static final Logger logger = Logger.getLogger(EventProducer.class.getName());
    
    @Inject
    private Event<TestEvent> events;
    
    public void produceSyncEvent(String data) {
        events.fire(TestEvent.of("FIRE SYNC"));
    }
    
    public void produceAsyncEvent(String data) {
        events.fireAsync(TestEvent.of("FIRE ASYNC")).exceptionally((t) -> {
            logger.log(Level.SEVERE, t, () -> "####################### Error while processing event");
            return null;
        });
    }
}
