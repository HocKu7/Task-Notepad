package ru.crud.component.task.repo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.crud.domain.Task;

import java.util.List;

@Repository
public class TaskRepoHibernate implements TaskRepo {

  private SessionFactory sessionFactory;

  public TaskRepoHibernate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session session() {
    try {

      return sessionFactory.getCurrentSession();
    }
    catch (HibernateException e) {
      return sessionFactory.openSession();
    }
  }

  @Override
  public List<Task> getTasksByUserId(Long id) {

    List id1 = session().createQuery("FROM Task WHERE OWNER_ID = :id")
        .setParameter("id", id)
        .list();

    return id1;
  }

  @Override
  public Task getTaskById(Long id) {
    return null;
  }

  @Override
  public Task save(Task task) {
    session().saveOrUpdate(task);
    return task;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public Task update(Task task) {
    return null;
  }
}
