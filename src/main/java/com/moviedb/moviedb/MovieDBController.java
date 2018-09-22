package com.moviedb.moviedb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.logging.Logger;


@Controller
public class MovieDBController {
    Logger log = Logger.getLogger(MovieDBController.class.getName());

    ArrayList<Movies> movies = new ArrayList<>();
    int movieiD;

    public MovieDBController() {
        movies.add(new Movies(0,1999,"Last Night With Death","https://www.youtube.com/watch?v=tyKyboTBsU4","Horror",11.21, "linkbillede"));
        movies.add(new Movies(1,2000,"Blue print to the Perfect body","http://www.link.dk","Documentary",1.58, "linkbillede2"));
    }

    @GetMapping("/")
    public String index(Model model) {
        log.info("Index called...");
        log.fine("Index: 0-> "+movies.get(0));

        model.addAttribute("movie", movies);

        return "index";
    }
    @GetMapping("/display")
    public String display(Model model){
        log.info("Display called");

        model.addAttribute("movie",movies.get(movieiD));



      return "display";
    }

}