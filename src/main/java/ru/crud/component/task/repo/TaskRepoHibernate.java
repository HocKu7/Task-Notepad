package ru.crud.component.task.repo;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.crud.domain.Task;

import java.util.List;

@Repository
public class TaskRepoHibernate implements TaskRepo {

  private SessionFactory sessionFactory;

  public TaskRepoHibernate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Task> getTasksByUserId(Long id) {

    Session session = sessionFactory.openSession();
    List list = session.createQuery("FROM Task WHERE owner_id = :id")
        .setParameter("id", id)
        .list();
    session.close();
    return list;
  }

  @Override
  public Task getTaskById(Long id) {

    Session session = sessionFactory.openSession();
    Task task = session.load(Task.class, id);
    session.close();
    return task;
  }

  @Override
  public Task save(Task task) {

    Session session = sessionFactory.openSession();
    session.save(task);
    session.flush();
    session.close();

    return task;
  }

  @Override
  public void delete(Long id) {

    Session session = sessionFactory.openSession();
    session.createQuery("DELETE FROM Task WHERE id= :id")
        .setParameter("id", id)
        .executeUpdate();
  }

  @Override
  public Task update(Task task) {

    Session session = sessionFactory.openSession();
    session.update(task);
    session.flush();
    session.close();
    return task;
  }
}
