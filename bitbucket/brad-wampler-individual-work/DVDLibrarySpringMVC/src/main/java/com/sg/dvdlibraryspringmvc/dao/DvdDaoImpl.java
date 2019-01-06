/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author bwamp
 */
public class DvdDaoImpl implements DvdDao {
    
  public static final String DVD_FILE = "dvd.txt";
  public static final String DELIMITER = "::";
  
  HashMap <Integer, Dvd> dvdMap = fillLibrary();
  
  private HashMap <Integer, Dvd> fillLibrary(){
      HashMap <Integer, Dvd> dvdMap = new HashMap<>();
      
      Dvd newdvd = new Dvd();
      newdvd.setDvdId(1);
      newdvd.setDirectorsName("Tom");
      newdvd.setMpaaRatng("PG");
      newdvd.setReleaseDate("2017");
      newdvd.setTitle("Big Foot");
      newdvd.setUserRatingNotes("none");
      newdvd.setStudio("studio 11");
      dvdMap.put(newdvd.getDvdId(), newdvd);
      
      newdvd = new Dvd();
      newdvd.setDvdId(2);
      newdvd.setDirectorsName("Tom");
      newdvd.setMpaaRatng("R");
      newdvd.setReleaseDate("2018");
      newdvd.setTitle("Big Foot II");
      newdvd.setStudio("studio 11");
      newdvd.setUserRatingNotes("none");
      dvdMap.put(newdvd.getDvdId(), newdvd);

      newdvd = new Dvd();
      newdvd.setDvdId(3);
      newdvd.setDirectorsName("Greg");
      newdvd.setMpaaRatng("PG");
      newdvd.setReleaseDate("2018");
      newdvd.setTitle("Small Foot");
      newdvd.setStudio("studio 11");
      newdvd.setUserRatingNotes("none");
      dvdMap.put(newdvd.getDvdId(), newdvd);
      
      return dvdMap;
}


    @Override
    public Dvd addDvd(Dvd newDvd ){
        Dvd addDvd = dvdMap.put(newDvd.getDvdId(), newDvd);
        return addDvd;
    }

    @Override
    public void removeDvd(int dvdId){
        dvdMap.remove(dvdId);
    }

    @Override
    public void editDvd(Dvd dvd){      
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<Dvd> listDvd(){
        return new ArrayList<>(dvdMap.values());
    }

    @Override
    public Dvd searchForDvd(int searchFor){
        Dvd newDvd = dvdMap.get(searchFor);
        return newDvd;
    }
    @Override
    public List <Dvd> searchAllDvd(String searchCategory, String searchTerm){
        List<Dvd> searchList = new ArrayList<Dvd>(dvdMap.values());
        List <Dvd> newList = new ArrayList();

        if ("title".equals(searchCategory)) {
            for (Dvd currentDvd: searchList ){
                if (currentDvd.getTitle().endsWith(searchTerm)){
                    newList.add(currentDvd);
                }
            }
        }else if ("releaseYear".equals(searchCategory)){
            for (Dvd currentDvd: searchList ){
                if (currentDvd.getReleaseDate().equals(searchTerm)){
                    newList.add(currentDvd);
                }
            }
        }else if ("directorsName".equals(searchCategory)){
            for (Dvd currentDvd: searchList ){
                if (currentDvd.getDirectorsName().equals(searchTerm)){
                    newList.add(currentDvd);
                }
            }
        }else if ("mpaaRating".equals(searchCategory)){
            for (Dvd currentDvd: searchList ){
                if (currentDvd.getMpaaRatng().equals(searchTerm)){
                    newList.add(currentDvd);
                }
            }       
        }
        return newList;
    }
                
    
}
