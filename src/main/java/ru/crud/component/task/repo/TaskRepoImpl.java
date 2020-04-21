package ru.crud.component.task.repo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.crud.component.task.domain.Task;
import ru.crud.component.user.domain.User;
import ru.crud.component.user.repo.UserRepoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskRepoImpl implements TaskRepo {

  private NamedParameterJdbcTemplate jdbcTemplate;
  private static final String SELECT_TASKS_BY_USER_ID = "SELECT * FROM TASK WHERE owner_id=:user_id";
  private static final String INSERT_TASK = "INSERT INTO TASK(id, owner_id, description, status) VALUES (:id, :owner_id, :description, :status)";

  public TaskRepoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Task> getTasksByUserId(Long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("user_id", id);

    return jdbcTemplate.query(SELECT_TASKS_BY_USER_ID, parameters, new TaskRepoImpl.TaskMapper());
  }

  @Override
  public Task save(Task task) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", task.getId())
        .addValue("owner_id", task.getUserId())
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
      task.setUserId(resultSet.getLong("owner_id"));
      task.setDescription(resultSet.getString("description"));
      task.setStatus(resultSet.getString("status"));

      return task;
    }
  }
}
