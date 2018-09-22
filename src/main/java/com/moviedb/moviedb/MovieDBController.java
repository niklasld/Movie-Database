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

    Files file = new Files();

    public MovieDBController() {
        file.createFile();
        file.openFile();
        file.readFile();
        movies = file.returnArray();
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