package com.moviedb.moviedb;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Files {

    Scanner scanFile;
    private ArrayList<Movies> movies = new ArrayList<>();

    public void createFile() {
        final Formatter movies;

        File movies = new File("Movies.txt");

        if(!movies.exists()) {
            try {
                movies = new Formatter("Movies.txt")
            }
            catch(Exception e) {
                System.out.println("Error creating file Movies.txt");
            }

        }
    }

    public void openFile() {
        try {
            scanFile = new Scanner(new File("Movies.txt"));
        }
        catch (Exception e) {
            System.out.println("Could not find file Movies.txt");
        }
    }

    public void readFile() {
        createFile();
        openFile();
        int movieId, year;
        String movieTitle, link, pictureLink, genre;
        double duration;

        while(scanFile.hasNext()) {
            movieId = scanFile.nextInt();
            year = scanFile.nextInt();
            movieTitle = scanFile.next();
            link = scanFile.next();
            pictureLink = scanFile.next();
            genre = scanFile.next();
            duration = scanFile.nextDouble();

            movies.add(new Movies(movieId,year,movieTitle,link,genre,duration,pictureLink));

        }

        scanFile.close();

    }

    public ArrayList<Movies> returnArray() {
        return movies;
    }
}
