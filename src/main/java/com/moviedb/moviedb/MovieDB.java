package com.moviedb.moviedb;

import java.util.ArrayList;

public class MovieDB {

    public void searchMovie(ArrayList<Movies> movies){
        String search = "Batman";
        int id, year;
        String Title, link, genre;
        double duration;

        search = search.toLowerCase();

        for (Movies m: movies) {
            if(m.getMovieTitle().toLowerCase().contains(search)){
                //show movie match here
            }
        }

    }
}
