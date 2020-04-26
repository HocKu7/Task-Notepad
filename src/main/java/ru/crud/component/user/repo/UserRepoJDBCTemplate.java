package ru.crud.component.user.repo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepoJDBCTemplate implements UserRepo {

  private NamedParameterJdbcTemplate jdbcTemplate;
  private static final String SELECT_USER_BY_ID = "SELECT * FROM USER WHERE id=:id";
  private static final String SELECT_USER_BY_NAME = "SELECT * FROM USER WHERE name=:name";
  private static final String INSERT_USER = "INSERT INTO USER (id, name, password) VALUES (:id, :name, :password)";
  private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE id=:id";
  private static final String UPDATE_USER = "UPDATE USER SET name=:name, password=:password WHERE id=:id";

  public UserRepoJDBCTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public User getById(long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", id);

    return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, parameters, new UserMapper());
  }

  @Override
  public List<User> getUsersByName(String name) {

    //TODO
    return null;
  }

  @Override
  public User save(User user) {

    KeyHolder holder = new GeneratedKeyHolder();

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", user.getId())
        .addValue("name", user.getName())
        .addValue("password", user.getPassword());

    jdbcTemplate.update(INSERT_USER, parameters, holder);

    user.setId(holder.getKey()
        .longValue());

    return user;
  }

  @Override
  public User update(User user) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", user.getId())
        .addValue("name", user.getName())
        .addValue("password", user.getPassword());

    jdbcTemplate.update(UPDATE_USER, parameters);

    return user;
  }

  @Override
  public void deleteById(long id) {

    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("id", id);

    jdbcTemplate.update(DELETE_USER_BY_ID, parameters);
  }

  @Override
  public List<User> getAllUsers() {
    return null;
  }

  private static final class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

      User user = new User();
      user.setId(resultSet.getLong("id"));
      user.setName(resultSet.getString("name"));
      user.setPassword(resultSet.getString("password"));

      return user;
    }
  }
}
