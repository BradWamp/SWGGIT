/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DvdDao;
import DAO.DvdDaoException;
import DTO.Dvd;
import Service.DvdServiceLayer;
import UI.DvdLibraryView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DvdController {
    public DvdLibraryView view;
    public DvdServiceLayer service;
    
    
    public DvdController(DvdServiceLayer service, DvdLibraryView view){
        this.service = service;
        this.view = view;
    }
    
    private boolean runProgram = true;
    private int userSelection;
    
    public void run(){
        
        try {
        while(runProgram){
            userSelection = view.getUserOption();
            if (userSelection == 1){
                addDvd();
            } else if (userSelection == 2){
                removeDvd();
            } else if (userSelection == 3){
                editDvd();
            } else if (userSelection == 4){
                listDvd();
            } else if (userSelection == 5){
                searchForDvd();
            } else if (userSelection == 6) {
                break;
            } else if (userSelection ==7) {
                listMoviesByDirector();
            } else if (userSelection == 8) {
                listMoviesByStudio();
            } else if (userSelection == 9) {
                listMoviesBetweenDates();
            }else if (userSelection == 10) {
                getDvdAvgAge();
            }else if (userSelection == 11) {
                getDvdByMpaa();
            }else if (userSelection == 12) {
                getNewestMovie();
            }else if (userSelection == 13) {
                getOldestMovie();
            }
            else{System.out.println("Please select a valid menu option");}
        }
        }catch (DvdDaoException e){
            System.out.println("Error");
        }
    }
    public void addDvd() throws DvdDaoException {
        boolean loopAgain = true;
      		while(loopAgain){
      	       Dvd newDvd = view.inputDvdInfo();
      		   service.addDvd(newDvd.getTitle(), newDvd);
      
      		   int performLoop = view.loopFunction(); 
               if(performLoop == 1) {
                 loopAgain = true;
               }else {
                 loopAgain = false;
               }
            }
    }
    public void removeDvd() throws DvdDaoException {
      	boolean loopAgain = true;
      		while(loopAgain){
              String removeTitle = view.removeDvd();
      		  service.removeDvd(removeTitle);
              
               int performLoop = view.loopFunction(); 
               if(performLoop == 1) {
                 loopAgain = true;
               }else {
                 loopAgain = false;
               }
            }	
    }
    public void editDvd() throws DvdDaoException {
        boolean loopAgain = true;
      	
      		while (loopAgain){
              String dvdEditTitle = view.returnTitle();
              int dvdEditField = view.returnField();
              String dvdEditFieldString = view.returnFieldString();
              service.editDvd(dvdEditTitle, dvdEditField, dvdEditFieldString);
              
              int performLoop = view.loopFunction();
      		  if(performLoop == 1) {
                loopAgain = true;
              }else {
                loopAgain = false;
              }
            }
    }
    public void listDvd() throws DvdDaoException {
        List<Dvd> listOfDvd = service.listDvd();
      	view.listDvd(listOfDvd);
      	view.listDvdMessage();
    }
    public void searchForDvd() throws DvdDaoException {
        String searchFor = view.searchForDvd();
      	Dvd newDvd = service.searchForDvd(searchFor);
        view.printSearchResults(newDvd);
    }
    public void listMoviesByDirector() throws DvdDaoException {
        String director = view.returnMoviesByDirector();
        Map <String, List<Dvd>> movieDirector = service.getDvdByDirector(director);
        Set <String> newSet = movieDirector.keySet();
        newSet.forEach(n -> {
                    System.out.println("*****************");
                    System.out.println("MPAA " + n);
                    movieDirector.get(n).stream().forEach(s -> System.out.println(s.getTitle()));
                    });
    }
    public void listMoviesByStudio() throws DvdDaoException {
        String studio = view.returnMoviesByStudio();
        List<Dvd> movieStudio = service.getDvdByStudio(studio);
        movieStudio.stream().forEach(d -> System.out.println(d.getTitle()));
    }
    public void listMoviesBetweenDates() throws DvdDaoException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate startDate = LocalDate.parse(view.returnMoviesBetweenDates1(), formatter);
        LocalDate endDate = LocalDate.parse(view.returnMoviesBetweenDates2(), formatter);
      
        List<Dvd> newDvd = service.getDvdBetweenYears(startDate, endDate);
        newDvd.stream().forEach(d -> System.out.println(d.getTitle()));
    }
    public void getDvdAvgAge() throws DvdDaoException {
        System.out.println("Average Dvd age " + service.getAverageDvdAge());
    }
    public void getDvdByMpaa() throws DvdDaoException {
        String mpaa = view.returnMoviesByMpaa();
        List<Dvd> movieMpaa = service.getDvdByMpaa(mpaa);
        movieMpaa.stream().forEach(m -> System.out.println(m.getTitle()));
    }
    public void getNewestMovie() throws DvdDaoException {
        Dvd newDvd = service.getMinDate();
        System.out.println(newDvd.getTitle());
    }
    public void getOldestMovie() throws DvdDaoException {
        Dvd newDvd = service.getMaxDate();
        System.out.println(newDvd.getTitle());
    }
}
