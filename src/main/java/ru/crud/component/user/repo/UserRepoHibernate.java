package ru.crud.component.user.repo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.crud.domain.User;

@Repository("userRepoHibernate")
public class UserRepoHibernate implements UserRepo {

  private SessionFactory sessionFactory;

  public UserRepoHibernate(SessionFactory sessionFactory){
      this.sessionFactory=sessionFactory;
  }

  public Session session(){
    try{

      return sessionFactory.getCurrentSession();
    }catch (HibernateException e){
      return sessionFactory.openSession();
    }
  }
  @Override
  public User getById(long id) {
    return session().byId(User.class).getReference(id);
  }

  @Override
  public User getUserByName(String name) {
    return null;
  }

  @Override
  public User save(User user) {

    session().saveOrUpdate(user);
    return null;
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public void deleteById(long id) {

  }
}
