package com.nb.dao;

import com.nb.beans.Spitter;
import com.nb.beans.Spittle;
import com.nb.dao.interfaces.SpitterRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcSpitterRepositoryImpl implements SpitterRepository{
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, firstname, lastname) values (?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, password = ?, firstname = ?, lastname = ?"
                    + "where id = ?";
    private static final String SQL_SELECT_SPITTERS = "select * from spitter";
    private static final String SQL_SELECT_SPITTER = "select * from spitter where id = :id";
    private static final String SQL_SELECT_SPITTER_BY_USERNAME = "select * from spitter where username = :username";

    @Inject
    private JdbcTemplate jdbcTemplate;
    @Inject
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addSpitter(Spitter spitter){
        jdbcTemplate.update(SQL_INSERT_SPITTER, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName());
    }
    public void updateSpitter(Spitter spitter){
        jdbcTemplate.update(SQL_UPDATE_SPITTER, spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName(), spitter.getId());
    }
    public Spitter findById(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_SPITTER, params, new SpitterRowMapper());
    }

    public Spitter findByUsername(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", userName);

        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_USERNAME, params, new SpitterRowMapper());
    }

    public List<Spitter> findAll() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_SELECT_SPITTERS);
        List<Spitter> spitters = new ArrayList<Spitter>();
        for (Map row : rows) {
            Spitter spitter = new Spitter();
            spitter.setId((Long)(row.get("id")));
            spitter.setUsername((String)row.get("username"));
            spitter.setPassword((String)row.get("password"));
            spitter.setFirstName((String)row.get("firstname"));
            spitter.setLastName((String)row.get("lastname"));
            spitters.add(spitter);
        }
        return spitters;
    }

    private static final class SpitterRowMapper
            implements RowMapper<Spitter> , Serializable {
        public Spitter mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            return new Spitter(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
        }
    }
}
