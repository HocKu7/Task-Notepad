package ru.crud.component.task.repo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.crud.domain.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaskRepoJDBC implements TaskRepo {

  private NamedParameterJdbcTemplate jdbcTemplate;
  private static final String SELECT_TASKS_BY_USER_ID = "SELECT * FROM TASK WHERE owner_id=:user_id";
  private static final String INSERT_TASK = "INSERT INTO TASK(id, owner_id, description, status) VALUES (:id, :owner_id, :description, :status)";
  private static final String DELETE_TASK_BY_ID = "DELETE FROM TASK WHERE id=:id";
  private static final String TASK_BY_ID="SELECT * FROM TASK WHERE id=:id";

  public TaskRepoJDBC(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Task> getTasksByUserId(Long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("user_id", id);

    return jdbcTemplate.query(SELECT_TASKS_BY_USER_ID, parameters, new TaskRepoJDBC.TaskMapper());
  }

  @Override
  public Task getTaskById(Long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", id);

    return jdbcTemplate.queryForObject(TASK_BY_ID,parameters,new TaskRepoJDBC.TaskMapper());
  }

  @Override
  public Task save(Task task) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", task.getId())
        .addValue("description", task.getDescription())
        .addValue("status", task.getStatus());

    KeyHolder holder = new GeneratedKeyHolder();

    jdbcTemplate.update(INSERT_TASK, parameters, holder);

    task.setId(holder.getKey()
        .longValue());

    return task;
  }

  @Override
  public void delete(Long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", id);

    jdbcTemplate.update(DELETE_TASK_BY_ID, parameters);
  }

  @Override
  public Task update(Task task) {
    return null;
  }

  private static final class TaskMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {

      Task task = new Task();
      task.setId(resultSet.getLong("id"));
      task.setDescription(resultSet.getString("description"));
      task.setStatus(resultSet.getString("status"));

      return task;
    }
  }
}
