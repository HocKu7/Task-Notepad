package ru.crud.component.task.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.crud.domain.Task;

import java.util.List;

@Repository
@Transactional
public class TaskRepoHibernate implements TaskRepo {

  private SessionFactory sessionFactory;

  public TaskRepoHibernate(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Task> getTasksByUserId(Long id) {

    Session session = sessionFactory.getCurrentSession();
    List tasks =  session.createQuery("FROM Task WHERE owner_id = :id")
        .setParameter("id", id)
        .list();

    return tasks;
  }

  @Override
  public Task getTaskById(Long id) {

    Session session = sessionFactory.getCurrentSession();
    Task task = session.load(Task.class, id);

    return task;
  }

  @Override
  public void save(Task task) {

    Session session = sessionFactory.getCurrentSession();
    session.save(task);
  }

  @Override
  public void delete(Long id) {

    Session session = sessionFactory.getCurrentSession();
    Task task =session.load(Task.class, id);
    session.delete(task);
  }

  @Override
  public void update(Task task) {

    Session session = sessionFactory.getCurrentSession();
    session.update(task);
  }
}
