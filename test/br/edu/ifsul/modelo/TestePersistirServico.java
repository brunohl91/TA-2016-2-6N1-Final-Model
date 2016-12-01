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
public class TestePersistirServico {
  
  EntityManagerFactory emf;
  EntityManager em;
  
  public TestePersistirServico() {
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
      Servico obj = new Servico ();
      obj.setNome("Teste");
      obj.setCusto(0.0);
      obj.setQtde(10.0);
      obj.setCustoCobrado(0.5);
      obj.setUnidade("Minutos");
      obj.setConta(em.find(Conta.class, 2));
      em.getTransaction().begin();
      em.persist(obj);
      em.getTransaction().commit();
    } catch (Exception e) {
      exception = true;
      e.printStackTrace();
    }
    Assert.assertEquals(false, exception);
  }
  
}
