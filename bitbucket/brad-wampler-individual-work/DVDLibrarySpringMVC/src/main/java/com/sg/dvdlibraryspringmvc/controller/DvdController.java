/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import com.sg.dvdlibraryspringmvc.service.DvdServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bwamp
 */
@Controller

public class DvdController {

    DvdServiceLayer service;
    
    @Inject
    public DvdController (DvdServiceLayer service){
        this.service = service;
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        List<Dvd> dvdList = service.listDvd();
        model.addAttribute("dvdList", dvdList);

        return "home";
    }

    @RequestMapping(value = "createDvd", method = RequestMethod.GET)
    public String createDvd(HttpServletRequest request, Model model) {

        return "createDvd";
    }
    @RequestMapping(value = "dvdDetail", method = RequestMethod.GET)
    public String dvdDetail(HttpServletRequest request, Model model) {
        int parameter = Integer.parseInt(request.getParameter("dvdId"));
        Dvd dvd = service.searchForDvd(parameter);
        model.addAttribute("dvd", dvd);
        return "dvdDetail";
    }

    @RequestMapping(value ="/createNewDvd", method = RequestMethod.POST)
    public String createNewDvd(HttpServletRequest request) {
     
        Dvd dvd = new Dvd();
        dvd.setTitle(request.getParameter("title"));
        dvd.setDirectorsName(request.getParameter("directorsName"));
        dvd.setMpaaRatng(request.getParameter("mpaaRatng"));
        dvd.setReleaseDate("releaseDate");
        dvd.setStudio(request.getParameter("studio"));
        dvd.setUserRatingNotes(request.getParameter("userRatingNotes"));

        service.addDvd(dvd);
        return "redirect:home";
       }
    @RequestMapping(value = "cancel", method = RequestMethod.GET)
    public String cancel(HttpServletRequest request, Model model) {

        return "redirect:home";
    }

    @RequestMapping(value = "submitCreation", method = RequestMethod.GET)
    public String submitCreation(HttpServletRequest request, Model model) {
        return "redirect:home";
    }

    @RequestMapping(value = "searchDvd", method = RequestMethod.GET)
    public String searchDvd(HttpServletRequest request, Model model) {
        String searchCategory = request.getParameter("searchCategory");
        String searchTerm = request.getParameter("searchTerm");
        List<Dvd> newList = service.searchAllDvd(searchCategory, searchTerm);
        model.addAttribute("newList", newList);
        
        return "searchDvd";
    }

    @RequestMapping(value = "editDvdDetails", method = RequestMethod.GET)
    public String editDvd(HttpServletRequest request, Model model) {
        String stringParameter = request.getParameter("dvdId");
        int parameter = Integer.parseInt(stringParameter);
        Dvd dvd = service.searchForDvd(parameter);
        model.addAttribute("dvd", dvd);
        return "editDvd";
    }

    @RequestMapping(value = "/editDvd", method = RequestMethod.POST)
    public String replaceDvd(@Valid @ModelAttribute("dvd") Dvd dvd, BindingResult result) {

        service.editDvd(dvd);
        return "redirect:home";
    }
    @RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
    public String deleteDvd(HttpServletRequest request) {
        int idParameter = Integer.parseInt(request.getParameter("dvdId"));
        service.removeDvd(idParameter);
        return "redirect:home";
    }

}
