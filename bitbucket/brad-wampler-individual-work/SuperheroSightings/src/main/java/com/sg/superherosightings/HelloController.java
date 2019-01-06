package com.sg.superherosightings;

import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sg.superherosightings.dao.LocationDao;
import com.sg.superherosightings.dao.OrganizationDao;
import com.sg.superherosightings.dao.SightingDao;
import com.sg.superherosightings.dao.SuperpowerDao;
import com.sg.superherosightings.service.HeroService;
import com.sg.superherosightings.service.LocationService;
import com.sg.superherosightings.service.OrganizationService;
import com.sg.superherosightings.service.SightingService;
import com.sg.superherosightings.service.SuperpowerService;

@Controller
@RequestMapping({"/hero"})
public class HelloController {
        
    LocationService myLocation;
    HeroService myHero;
    OrganizationService myOrg;
    SuperpowerService myPower;
    SightingService mySight;
    
    @Inject
    public HelloController (LocationService myLocation, HeroService myHero, OrganizationService myOrg, SuperpowerService myPower, SightingService mySight){
        this.myLocation = myLocation;
        this.myHero= myHero;
        this.myOrg = myOrg;
        this.myPower = myPower;
        this.mySight = mySight;
    }
    
    
    @RequestMapping(value="/sayhi", method=RequestMethod.GET)
    public String sayHi(Map<String, Object> model) throws Exception {
        
        
//        List <Sighting> sightingList = mySight.listAllSightings();
//        Sighting selectSight = mySight.selectSighting(1);
//        Sighting addSight = new Sighting();
//        addSight.setLocationId(1);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        addSight.setSightingDate(LocalDate.parse("2020-12-28", dtf));
//        Sighting updateSight = mySight.addSighting(addSight);
//        updateSight.setLocationId(2);
//        mySight.updateSighting(updateSight);
//        mySight.deleteSighting(updateSight.getSightingId());
        
        
        
//        List <Superpower> power = myPower.listAllPowers();
//        Superpower newpower = myPower.selectPower("sneezing");
//        Superpower addpower = new Superpower();
//        addpower.setSuperpowerName("test");
//        addpower.setSuperpowerDesc("Testing the power");
//        Superpower updatepower = myPower.addPower(addpower);
//        updatepower.setSuperpowerName("update test");
//        myPower.updatePower(updatepower);
//        myPower.deletePower(updatepower.getSuperpowerId());
        
         
        
//       List <Organization> orgbyhero = myOrg.orgByHero("Rock");
//       List <Organization> herobyorg = myOrg.heroByOrg("wannabees");
//       Organization selectorg = myOrg.selectOrg("wannabees");
//       List <Organization> listallorg = myOrg.listAllOrg();
//       Organization addorg = new Organization();
//       addorg.setEmail("test");
//       addorg.setLocationfkId(1);
//       addorg.setOrganizationDesc("test description");
//       addorg.setOrganizationName("test name");
//       addorg.setPhone("9132323965");
//       Organization testorg = myOrg.addOrg(addorg);
//       testorg.setOrganizationName("updated name");
//       myOrg.updateOrg(testorg);
//       myOrg.deleteOrg(testorg.getOrganizationId());
       
       
       
       
//       Hero newhero = new Hero();
//       Superpower newsuperpower = new Superpower();
//       newsuperpower.setSuperpowerId(1);
//       newhero.setSuperpower(newsuperpower);
//       newhero.setHeroName("Test hero");
//       newhero.setHeroDesc("This is a test");
//       
//        
//        Hero testhero = myHero.addHero(newhero, newsuperpower); 
//        testhero.setHeroName("update name");
//        myHero.updateHero(testhero, newsuperpower);
//        myHero.deleteHero(testhero.getHeroId());
//        myHero.listAllHeroes();
        
//          myHero.selectHero("Rock");
//        List <Location> locationHeroByDate = myLocation.locationHeroByDate("2012-12-28");
//        locationHeroByDate.get(0);
////        List<Location> locationByHero = myLocation.locationByHero("Rock");
//        Location location = new Location();
//        location.setCity("testy");
//        location.setLat(31.11);
//        location.setLocationDesc("test");
//        location.setLocationId(4);
//        location.setLocationName("testnew");
//        location.setLongitude(31.44);
//        location.setState("test");
//        location.setStreet("street");
//        Location addLocation = myLocation.addLocation(location);
        
//        myLocation.deleteLocation(newlocation.getLocationId());
        
        
        //myLocation.updateLocation(location);
        //List<Location> allLocations = myLocation.listAllLocations();
        //List<Location> newList = myLocation.heroByLocation("Walmart");  
        
        model.put("message", "Hello from the controller" );
        return "hero";
    }
}
