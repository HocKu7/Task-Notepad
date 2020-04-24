package ru.crud.component.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateUtil {

  private HibernateUtil(){ }

  @Autowired
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }

}
