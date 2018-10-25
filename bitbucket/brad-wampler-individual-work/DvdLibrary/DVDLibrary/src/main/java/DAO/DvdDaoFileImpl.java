/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author bwamp
 */
import DTO.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DvdDaoFileImpl implements DvdDao {
    
  public static final String DVD_FILE = "dvd.txt";
  public static final String DELIMITER = "::";
  
  HashMap <String, Dvd> dvdMap = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd newDvd ) throws DvdDaoException{
        Dvd addDvd = dvdMap.put(title, newDvd);
        writeDvd();
        return addDvd;
    }

    @Override
    public void removeDvd(String title) throws DvdDaoException{
        dvdMap.remove(title);
        writeDvd();
    }

    @Override
    public void editDvd(String returnTitle, int returnField, String returnFieldString) throws DvdDaoException{
        Dvd newDvd = dvdMap.get(returnTitle);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          if(returnField == 1){
            newDvd.setTitle(returnFieldString);
          } else if (returnField == 2){
            LocalDate dt = LocalDate.parse(returnFieldString,dtf);
            newDvd.setReleaseDate(dt);
          } else if (returnField == 3){
            newDvd.setMpaaRatng(returnFieldString);
          } else if (returnField == 4) {
            newDvd.setDirectorsName(returnFieldString);
          } else if (returnField == 5){
            newDvd.setStudio(returnFieldString);
          } else if (returnField == 6) {
            newDvd.setUserRatingNotes(returnFieldString);
          } else{}
      
        dvdMap.put(returnTitle, newDvd);
        writeDvd();
    }

    @Override
    public List<Dvd> listDvd() throws DvdDaoException{
        loadDvd();
        return new ArrayList<Dvd>(dvdMap.values());
    }

    @Override
    public Dvd searchForDvd(String searchFor)throws DvdDaoException{
        Dvd newDvd = dvdMap.get(searchFor);
        loadDvd();
        return newDvd;
    }
    
   @Override
    public Map <String, List<Dvd>> getDvdByDirector(String director) {
        return dvdMap.values().stream()
                .filter(d -> d.getDirectorsName()
                .equalsIgnoreCase(director))
                //.collect(Collectors.toList());
                .collect(Collectors.groupingBy(d -> d.getMpaaRatng()));
    }
    
    @Override
    public List<Dvd> getDvdByStudio(String studio) {
        return dvdMap.values().stream()
                .filter(d -> d.getStudio()
                .equalsIgnoreCase(studio))
                .collect(Collectors.toList()); 
    }
    
    @Override
    public List<Dvd> getDvdBetweenYears(LocalDate startYear, LocalDate endYear) {
        return dvdMap.values().stream()
                .filter(s -> s.getReleaseDate().compareTo(startYear) > 1).filter(s -> s.getReleaseDate().compareTo(endYear)<0)
                .collect(Collectors.toList());
    }
    
    @Override
    public double getAverageDvdAge() {
        return dvdMap.values().stream()
                .mapToLong(s -> s.getDvdAge())
                .average()
                .getAsDouble();
    }
    
    @Override
    public List<Dvd> getDvdByMpaa(String mpaa) {
        return dvdMap.values().stream()
                .filter(d -> d.getMpaaRatng()
                .equalsIgnoreCase(mpaa))
                .collect(Collectors.toList());
    }
    
    @Override
    public Dvd getMinDate(){
        List<Dvd> newDvdList = new ArrayList(dvdMap.values());
        Dvd newDvd = Collections.max(newDvdList,Comparator.comparing(d -> d.getReleaseDate()));
        return newDvd;
            
        //return dvdMap.values().stream().mapToLong(s -> s.getDvdAge())
          //      .max().getAsLong();
    }
    
    @Override
    public Dvd getMaxDate(){
        List<Dvd> newDvdList = new ArrayList(dvdMap.values());
        Dvd newDvd = Collections.min(newDvdList,Comparator.comparing(d -> d.getReleaseDate()));
        return newDvd;
    }
    
    public void loadDvd() throws DvdDaoException{
        Scanner scanner;
	String currentLine;
        String[] currentTokens;
	try {
	    scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
	} catch (FileNotFoundException e) {
	    throw new DvdDaoException("load failed", e);
	}
        
        while (scanner.hasNextLine()) {
	    currentLine = scanner.nextLine();
	    currentTokens = currentLine.split(DELIMITER);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dt;
            Dvd currentDvd = new Dvd();
	    
	    currentDvd.setTitle(currentTokens[0]);
            currentDvd.setReleaseDate(LocalDate.parse(currentTokens[1],dtf));
	    currentDvd.setMpaaRatng(currentTokens[2]);
	    currentDvd.setDirectorsName(currentTokens[3]);
	    currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserRatingNotes(currentTokens[5]);
            
	    dvdMap.put(currentDvd.getTitle(), currentDvd);
	    }
	    
	    scanner.close(); // is this to save memory?
    }
    private void writeDvd() throws DvdDaoException {
	  
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DvdDaoException(
	                "Could not save data.", e);
	    }
	    
	    List<Dvd> dvdList = this.listDvd();
	    for (Dvd currentDvd : dvdList) {
	        // write the Student object to the file
	        out.println(currentDvd.getTitle() + DELIMITER
	                + currentDvd.getReleaseDate() + DELIMITER 
	                + currentDvd.getMpaaRatng() + DELIMITER
	                + currentDvd.getDirectorsName() + DELIMITER
                        + currentDvd.getStudio() + DELIMITER
                        + currentDvd.getUserRatingNotes());
	        
	        out.flush();
	    }
	    
	    out.close();
	}
    
}
