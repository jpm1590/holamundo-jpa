/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.cliente;

import beans.dominio.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author olimpica
 */
public class ClienteEntidadPersona {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        Persona persona1 = new Persona("Lili","Puerto","Molina","ljohanna@","1234567");
        log.debug("Objeto a persistir: " + persona1);
        
        em.persist(persona1);
        
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        em.close();
    }    
}
