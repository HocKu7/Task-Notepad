package ru.crud.component.user.repo;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.crud.domain.User;

import java.util.List;

@Repository
@Slf4j
@Transactional
public class UserRepoHibernate implements UserRepo {

  private SessionFactory sessionFactory;

  public UserRepoHibernate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public User getById(long id) {

    Session session = sessionFactory.getCurrentSession();
    User user = session.load(User.class, id);
    log.info("Get user by id: " + user);

    return user;
  }

  @Override
  public List<User> getUsersByName(String name) {

    Session session = sessionFactory.getCurrentSession();
    List list = session.createQuery("FROM User WHERE name= :name")
        .setParameter("name", name)
        .list();
    log.info("Get users by name. Count users: " + list.size());
    return list;
  }

  @Override
  public void save(User user) {

    Session session = sessionFactory.getCurrentSession();
    session.save(user);
    log.info("User saved: " + user);
  }

  @Override
  public void update(User user) {

    Session session = sessionFactory.getCurrentSession();
    session.update(user);
    log.info("User updated: " + user);
  }

  @Override
  public void deleteById(long id) {

    Session session = sessionFactory.getCurrentSession();
    User user = session.load(User.class, id);
    session.delete(user);
    log.info("User deleted: " + user);
  }

  @Override
  public List<User> getAllUsers() {

    Session session = sessionFactory.getCurrentSession();
    List list = session.createQuery("FROM User")
        .list();
    log.info("Get all users. Count:" + list.size());

    return list;
  }
}
