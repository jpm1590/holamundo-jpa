/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.dominio.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author jpm1590
 */
public class TestEntidadPersona {

    static EntityManager em;
    static EntityTransaction tx;
    static EntityManagerFactory emf;
    Logger log = LogManager.getRootLogger();

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("PersonaPu");
    }

    @Before
    public void setup() {
        try {
            em = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPersonaEntity() {
        log.debug("Iniciando teest Persona Entity JPA");

        assertTrue(em != null);
        tx = em.getTransaction();
        tx.begin();

        Persona persona1 = new Persona("Juliana", "Puerto", "Molina", "jpm1590@", "1234567");

        log.debug("objeto a persistir" + persona1);

        em.persist(persona1);
        tx.commit();

        //assertTrue(persona1.getIdPersona() != null);
        
        log.debug("Objeto persistido: " + persona1);
        log.debug("Fin test persona entity JPA");
    }
    
    @After
    public void tearDown(){
        if(em != null){
            em.close();
        }
    }

}
