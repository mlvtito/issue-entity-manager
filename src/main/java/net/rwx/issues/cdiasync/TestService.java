/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rwx.issues.cdiasync;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author mlvtito
 */
@ApplicationScoped
public class TestService {
    private static final Logger logger = Logger.getLogger(TestService.class.getName());
    
    private final TestDAO testDAO;

    @Inject
    public TestService(TestDAO testDAO) {
        this.testDAO = testDAO;
    }
    
    @Transactional
    public void observeAsyncEvent(@ObservesAsync TestEvent event) {
        logger.log(Level.INFO, () -> "####################### Processing event " + event);
        testDAO.addData(event.getData());
    }
    
    @Transactional
    public void observeEvent(@Observes TestEvent event) {
        logger.log(Level.INFO, () -> "####################### Processing event " + event);
        testDAO.addData(event.getData());
    }
}
