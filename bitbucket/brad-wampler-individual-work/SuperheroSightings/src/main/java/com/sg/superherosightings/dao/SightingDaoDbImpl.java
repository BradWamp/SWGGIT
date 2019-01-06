/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bwamp
 */
public class SightingDaoDbImpl implements SightingDao {
     private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_ADD
            = "insert into sighting (location_id, sightdate) "
            + "values (?, ?)";
    private static final String SQL_UPDATE
            = "update sighting set location_id = ?, sightdate = ? where sighting_id = ? ";
    private static final String SQL_DELETE
            = "delete from sighting where sighting_id = ? ";
    private static final String SQL_LISTALLSIGHTS
            = "select * from sighting";
    private static final String SQL_SELECTSIGHT
            = "select * from sighting where sighting_id = ?";
    
    @Override
    public Sighting selectSighting(int sightingId) {
        return jdbcTemplate.queryForObject(SQL_SELECTSIGHT, new SightMapper(), sightingId);
    }

    @Override
    public List<Sighting> listAllSightings() {
        return jdbcTemplate.query(SQL_LISTALLSIGHTS, new SightMapper());
    }

    @Override
    public void updateSighting(Sighting sight) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(sight.getSightingDate());
        jdbcTemplate.update(SQL_UPDATE, sight.getLocationId(), sqlDate, sight.getSightingId());
    }

    @Override
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE, sightingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sight) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(sight.getSightingDate());
            jdbcTemplate.update(SQL_ADD,
                sight.getLocationId(), sqlDate);
                
        // query the database for the id that was just assigned
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the object and return it
        sight.setSightingId(newId);
        return sight;
    }

    private static final class SightMapper implements RowMapper<Sighting> {

        public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sighting sight = new Sighting();
            sight.setSightingId(rs.getInt("sighting_id"));
            sight.setLocationId(rs.getInt("location_id"));
            sight.setSightingDate(rs.getDate("sightdate").toLocalDate());
            return sight;
        }
    }
}
