/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bwamp
 */
public class DvdDaoDBImpl implements DvdDao {

    private static final String SQL_INSERT_DVD
            = "insert into dvd"
            + "(title, user_notes, directors_name, studio, release_year, mpaa_rating)"
            + "values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from dvd where dvd_id = ?";
    private static final String SQL_UPDATE_DVD
            = "update dvd set "
            + "title = ?, user_notes = ?, directors_name = ?, studio = ?, "
            + "release_year = ?, mpaa_rating = ? "
            + "where dvd_id = ?";
    private static final String SQL_SELECT_ALL_DVD
            = "select * from dvd";
    private static final String SQL_SELECT_DVD
            = "select * from dvd where dvd_id = ? ";
    private static final String SQL_SELECT_TITLE_DVD
            = "select * from dvd where title = ? ";
    private static final String SQL_SELECT_RELEASE_DVD
            = "select * from dvd where release_year = ? ";
    private static final String SQL_SELECT_DIRECTOR_DVD
            = "select * from dvd where directors_name = ? ";
    private static final String SQL_SELECT_RATING_DVD
            = "select * from dvd where mpaa_rating = ? ";
                  
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
           
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd newDvd) {
       jdbcTemplate.update(SQL_INSERT_DVD,
        newDvd.getTitle(),
        newDvd.getUserRatingNotes(),
        newDvd.getDirectorsName(),
        newDvd.getStudio(),
        newDvd.getReleaseDate(),
        newDvd.getMpaaRatng());
        
        int newID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        newDvd.setDvdId(newID);
        return newDvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void editDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getUserRatingNotes(),
                dvd.getDirectorsName(),
                dvd.getStudio(),
                dvd.getReleaseDate(),
                dvd.getMpaaRatng(),
                dvd.getDvdId());
    }

    @Override
    public List<Dvd> listDvd() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVD, new DvdMapper());
    }

    @Override
    public Dvd searchForDvd(int searchFor) {
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), searchFor);
 
    }

    @Override
    public List<Dvd> searchAllDvd(String searchCategory, String searchTerm) {
      
        List <Dvd> newList = new ArrayList();
        
        
        if ("title".equals(searchCategory)) {
            newList = jdbcTemplate.query(SQL_SELECT_TITLE_DVD, new DvdMapper(), searchTerm);
        }else if ("releaseYear".equals(searchCategory)){
            newList = jdbcTemplate.query(SQL_SELECT_RELEASE_DVD,new DvdMapper(), searchTerm);
        }else if ("directorsName".equals(searchCategory)){
            newList = jdbcTemplate.query(SQL_SELECT_DIRECTOR_DVD,new DvdMapper(), searchTerm);
        }else if ("mpaaRating".equals(searchCategory)){
            newList = jdbcTemplate.query(SQL_SELECT_RATING_DVD,new DvdMapper(), searchTerm);       
        }
        return newList;
    }
    
    private static final class DvdMapper implements RowMapper <Dvd> {
        
    public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dvd dvd = new Dvd();
        dvd.setDvdId(rs.getInt("dvd_id"));
        dvd.setTitle(rs.getString("title"));
        dvd.setUserRatingNotes(rs.getString("user_notes"));
        dvd.setDirectorsName(rs.getString("directors_name"));
        dvd.setStudio(rs.getString("studio"));
        dvd.setReleaseDate(rs.getString("release_year"));
        dvd.setMpaaRatng(rs.getString("mpaa_rating"));
        return dvd;
        }
    }

}
