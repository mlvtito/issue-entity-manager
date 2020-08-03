/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rwx.issues.cdiasync;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mlvtito
 */
@ApplicationScoped
public class TestDAO {
    
    @PersistenceContext(unitName = "app")
    private EntityManager entityManager;
    
    public void addData(String data){
        TestEntity entity = new TestEntity();
        entity.setData(data);
        entityManager.persist(entity);
    }
}
