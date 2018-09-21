package com.moviedb.moviedb;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class MovieDBController {
    Logger log = Logger.getLogger(MovieDBController.class.getName());

    ArrayList<Movies> movies = new ArrayList<>();

    public MovieDBController() {
        movies.add(new Movies(0,1999,"Last Night With Death","http://www.link.dk","Horror",11.21));
    }
}