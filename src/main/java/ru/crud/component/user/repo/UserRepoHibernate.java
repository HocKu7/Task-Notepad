package ru.crud.component.user.repo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.crud.domain.Task;
import ru.crud.domain.User;

import java.util.List;

@Repository
public class UserRepoHibernate implements UserRepo {

  private SessionFactory sessionFactory;

  public UserRepoHibernate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public User getById(long id) {

    return sessionFactory.openSession()
        .byId(User.class)
        .getReference(id);
  }

  @Override
  public List<User> getUsersByName(String name) {

    Session session = sessionFactory.openSession();
    List list = session.createQuery("FROM User WHERE name= :name")
        .list();
    session.close();
    return list;
  }

  @Override
  public User save(User user) {

    Session session = sessionFactory.openSession();
    session.save(user);
    session.flush();
    session.close();

    return null;
  }

  @Override
  public User update(User user) {

    Session session = sessionFactory.openSession();
    session.update(user);
    session.flush();
    session.close();
    return null;
  }

  @Override
  public void deleteById(long id) {

    try(Session session = sessionFactory.openSession()){

      Transaction transaction = session.beginTransaction();

      User user = session.byId(User.class)
          .getReference(id);
      session.delete(user);

      transaction.commit();
    }
  }

  @Override
  public List<User> getAllUsers() {

    Session session = sessionFactory.openSession();
    List list = session.createQuery("FROM User")
        .list();

    session.close();

    return list;
  }
}
