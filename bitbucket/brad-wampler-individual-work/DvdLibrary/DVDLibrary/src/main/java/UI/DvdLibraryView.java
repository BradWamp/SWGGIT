/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author bwamp
 */
import DTO.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DvdLibraryView {
    public UserIO io;
    
    public DvdLibraryView(UserIO io){
        this.io = io;
    }
 
    public int getUserOption() {
        io.print("---DVD Library Menu Selection---");
        io.print("1.Add DVD");
        io.print("2.Remove DVD");
        io.print("3.Edit DVD");
        io.print("4.List DVD");
        io.print("5.Search for DVD");
        io.print("6.Quit");
        io.print("7.List movies by director");
        io.print("8.List movies by studio");
        io.print("9.List movies between dates");
        io.print("10.Get Average age of Dvds");
        io.print("11.Get Dvds by Mpaa");
        io.print("12.Get Dvd by Newest");
        io.print("13.Get Dvds by Oldest");
        return io.readInt("Please select the number for the function you'd like to perform", 1,13);
    }
    public Dvd inputDvdInfo(){
      Dvd newDvd = new Dvd();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      
      io.print("---Adding Dvd to Library---");
      newDvd.setTitle(io.readString("What is the Title of the Dvd?"));
      LocalDate dt = LocalDate.parse(io.readString("What was the release date?"),dtf); //set string from user to localdate
      newDvd.setReleaseDate(dt);
      //newDvd.setReleaseDate(io.readString("What was the release date?"));
      newDvd.setMpaaRatng(io.readString("What is the MPAA rating?"));
      newDvd.setDirectorsName(io.readString("What is the Director's name?"));
      newDvd.setStudio(io.readString("What studio produced the movie?"));
      newDvd.setUserRatingNotes(io.readString("Add user notes or rating."));     
      
      return newDvd;
    }
    public String removeDvd(){
      return io.readString("!!!Removing DVD will be PERMANENT!!!\n" + "What is the name of the Dvd you wish to remove?");
    }
  	public void listDvd(List<Dvd> listOfDvd){
      for (Dvd currentDvd : listOfDvd) {
      	io.print("\nTitle: " + currentDvd.getTitle() + "| Released: " + currentDvd.getReleaseDate() + "| Director: " + currentDvd.getDirectorsName()
                +"| Studio: " + currentDvd.getStudio() + "| MPAA: " + currentDvd.getMpaaRatng() + "| User Notes: " + currentDvd.getUserRatingNotes());
        io.print("-------------------------");
      }
    }
  	public void listDvdMessage(){
      io.readString("\n!!!List Complete.!!!\n" + "Press enter to return to menu.\n");
    }
  	public String searchForDvd(){
      return io.readString("What is the name of the Dvd you want to display?");
    }
  	public void printSearchResults(Dvd currentDvd){
      if(currentDvd != null){
      		io.print("\n---DVD information---" + "\nTitle: " + currentDvd.getTitle() + "| Released: " + currentDvd.getReleaseDate() + "| Director: " + currentDvd.getDirectorsName()
                +"| Studio: " + currentDvd.getStudio() + "| MPAA: " + currentDvd.getMpaaRatng() + "| User Notes: " + currentDvd.getUserRatingNotes() + "\n");
    	} else {
        	io.print("\nThat title doesn't appear to be in the Library. Try adding it first or check spelling.\n");
      	}
    }
    public String returnTitle(){
        return io.readString("What is the title of the DVD you wish to edit?");
    }
  	public int returnField(){
      	io.print("\n1.Title");
        io.print("2.Release Date");
        io.print("3.MPAA Rating");
        io.print("4.Director's Name");
        io.print("5.Studio");
        io.print("6.User Rating/Notes");
        io.print("7.Quit");
      	return io.readInt("Select the number of the field you want to edit.", 1,7);
    }
  	public String returnFieldString(){
      return io.readString ("What do you want to update it to?");
    }
        public String returnMoviesByDirector() { // look for director name and return movies for that director
            return io.readString("What is the director name you are looking for?");
        }
        
        public String returnMoviesByStudio() { // look for director name and return movies for that director
            return io.readString("What is the studio name you are looking for?");
        }
        public String returnMoviesBetweenDates1() { // look for director name and return movies for that director
            return io.readString("What is the start date you are looking for? (Format yyyy-mm-dd)");
        }
        public String returnMoviesBetweenDates2() { // look for director name and return movies for that director
            return io.readString("What is the end date you are looking for? (Format yyyy-mm-dd)");
        }
        public String returnMoviesByMpaa () {
            return io.readString("What is the Mpaa you want to look for?");
        }
  	public int loopFunction() {
      return io.readInt("Would you like to perform this function again (select number)? | 1.Yes 2.No", 1,2);
    }
}


