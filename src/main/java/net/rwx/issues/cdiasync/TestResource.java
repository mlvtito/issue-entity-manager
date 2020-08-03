/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rwx.issues.cdiasync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author mlvtito
 */
@Path("test")
public class TestResource {

    private static final Logger logger = Logger.getLogger(TestResource.class.getName());
    
    @Inject
    private EventProducer events;
    
    @GET
    @Path("/sync")
    public String getSync() {
        events.produceSyncEvent("FIRE SYNC");
        return "TEST SYNC";
    }
    
    @GET
    @Path("/async")
    public String getAsync() {
        events.produceAsyncEvent("FIRE ASYNC");
        return "TEST ASYNC";
    }
}
