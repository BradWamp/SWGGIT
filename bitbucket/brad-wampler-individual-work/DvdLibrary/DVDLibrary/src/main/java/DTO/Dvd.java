/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author bwamp
 */
public class Dvd {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRatng;
    private String directorsName;
    private String studio;
    private String userRatingNotes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRatng() {
        return mpaaRatng;
    }

    public void setMpaaRatng(String mpaaRatng) {
        this.mpaaRatng = mpaaRatng;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingNotes() {
        return userRatingNotes;
    }

    public void setUserRatingNotes(String userRatingNotes) {
        this.userRatingNotes = userRatingNotes;
    }
    
    public long getDvdAge() {
        Period p = getReleaseDate().until(LocalDate.now());
        return p.getYears();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.title);
        hash = 11 * hash + Objects.hashCode(this.releaseDate);
        hash = 11 * hash + Objects.hashCode(this.mpaaRatng);
        hash = 11 * hash + Objects.hashCode(this.directorsName);
        hash = 11 * hash + Objects.hashCode(this.studio);
        hash = 11 * hash + Objects.hashCode(this.userRatingNotes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRatng, other.mpaaRatng)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRatingNotes, other.userRatingNotes)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return title + " |" + releaseDate + " |" + directorsName + " |" + mpaaRatng + " |" + studio + " |";
    }
    
}
