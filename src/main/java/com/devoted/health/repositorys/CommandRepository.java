package com.devoted.health.repositorys;

import com.devoted.health.domains.Command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommandRepository {

    private static Logger log = LoggerFactory.getLogger(CommandRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(Command command) {
        return jdbcTemplate.update("insert into command (id, name, value) " + "values(?,  ?, ?)",
                command.getId(), command.getName(), command.getValue());
    }

    public int update(Command command) {
        return jdbcTemplate.update("update command " + " set name = ?, value = ? " + " where id = ?",
                command.getName(), command.getValue(), command.getId());
    }

    public String findByName(String name) {
        String value = "NULL";
        try {
            Command command = jdbcTemplate.queryForObject("select * from command where name=?", new Object[]{name},
                    new BeanPropertyRowMapper<>(Command.class));
            value = command.getValue();

        } catch (EmptyResultDataAccessException | NullPointerException ex) {
            log.warn("dao object null pointer: " + ex);
        }
        return value;
    }

    public Command findObjectByName(String name) {
        Command command = null;
        try {
            command = jdbcTemplate.queryForObject("select * from command where name=?", new Object[]{name},
                    new BeanPropertyRowMapper<>(Command.class));

        } catch (EmptyResultDataAccessException | NullPointerException ex) {
            log.warn("dao object null pointer: " + ex);
        }
        return command;
    }

    public int countByValue(String value) {
        int count = 0;
        try {
            count = jdbcTemplate.queryForObject("select count(*) from command where value=?", new Object[]{value}, Integer.class);
        } catch (NullPointerException ex) {
            log.warn("dao object null pointer: " + ex);
        }
        return count;
    }

    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from command where name=?", name);
    }

}
