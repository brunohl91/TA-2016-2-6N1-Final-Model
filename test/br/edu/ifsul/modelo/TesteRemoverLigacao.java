/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class TesteRemoverLigacao {
  
  EntityManagerFactory emf;
  EntityManager em;
  
  public TesteRemoverLigacao() {
  }
  
  @Before
  public void setUp() {
    emf = Persistence.createEntityManagerFactory("TA-2016-2-6N1-Final-ModelPU");
    em = emf.createEntityManager();
  }
  
  @After
  public void tearDown() {
    em.close();
    emf.close();
  }
  
  @Test
  public void teste () {
    boolean exception = false;
    try {
      em.getTransaction().begin();
      em.remove(em.find(Ligacao.class, 4));
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
  
}
