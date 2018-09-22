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
    String test;

    public MovieDBController() {
        movies.add(new Movies(0,1999,"Last_Night_With_Death","http://www.link.dk","Horror",11.21));
        movies.add(new Movies(1,2011,"Batman","http://www.link.dk","Action",2.49));

    }

    @GetMapping("/")
    public String index(Model model) {
        log.info("Index called...");
        log.fine("Index: 0-> "+movies.get(0));

        model.addAttribute("movie", movies);

        return "index";
    }

    @GetMapping("/search")
    public String search(Model model){
        log.info("Index called...");
        log.fine("Index: 0-> "+movies.get(0));

        model.addAttribute("movie", movies);
        model.addAttribute("test",test);
        log.info(test);

        return "searchMovie";
    }

    @GetMapping("/style")
    public String style(){
        return "style";
    }
}