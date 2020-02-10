package com.cid.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

import static com.cid.dao.Queries.USER_BY_ID;
import static com.cid.dao.Queries.USER_BY_TEAM_ID;

@Repository
public class UserDaoNamedParametersJdbcTemplate implements UserDao{

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
		
	@Autowired
	private UserRowMapper userRowMapper;
	
	@Override
	public User findById(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return namedJdbcTemplate.queryForObject("select * from USER where id=:id", params, userRowMapper);	
	}

	@Override
	public List<User> findByTeamId(int teamId) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("team_id", teamId);
		return namedJdbcTemplate.query("select * from USER where team_id=:team_id", namedParameters,userRowMapper);
	}

	
	@Override
	public void createUser(User newUser) {	  
		throw new UnsupportedOperationException("Not yet implemented");	
		/*
		 * Map<String, Object> parameters = new HashMap<String, Object>();
		 * parameters.put("department_id", newUser.getDepartmentId());
		 * parameters.put("team_id", newUser.getTeamId()); parameters.put("role_id",
		 * newUser.getRoleId()); parameters.put("firstname", newUser.getFirstname());
		 * parameters.put("lastname", newUser.getLastname()); parameters.put("username",
		 * newUser.getUsername()); parameters.put("password", newUser.getPassword());
		 */			    
	}

	@Override
	public void loadAllUsers() {
		throw new UnsupportedOperationException("Not yet implemented");	
		
	}

	@Override
	public void deleteUser(int id) {
		throw new UnsupportedOperationException("Not yet implemented");	
		
	}

	@Override
	public void updateUser(int id, User userToUpdate) {
		throw new UnsupportedOperationException("Not yet implemented");	
		
	}

}
