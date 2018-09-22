package com.moviedb.moviedb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Files {

    Scanner scanFile;
    private ArrayList<Movies> movies = new ArrayList<>();

    public void createFile() {
        final Formatter movietxt;

        File movies = new File("Movies.txt");

        if(!movies.exists()) {
            try {
                movietxt = new Formatter("Movies.txt");
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
        String movieTitle, link, pictureLink, genre, duration;

        while(scanFile.hasNext()) {
            movieId = scanFile.nextInt();
            year = scanFile.nextInt();
            movieTitle = scanFile.next();
            link = scanFile.next();
            genre = scanFile.next();
            duration = scanFile.next();
            pictureLink = scanFile.next();


            movies.add(new Movies(movieId,year,movieTitle,link,genre,duration,pictureLink));

        }

        scanFile.close();

    }

    public ArrayList<Movies> returnArray() {
        return movies;
    }

    public void clearFile() {
        try {
            FileWriter fileW = new FileWriter("Movies.txt");
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write("");
            buffW.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {
        try {
            FileWriter fileW = new FileWriter("Movies.txt",true);
            BufferedWriter buffW = new BufferedWriter(fileW);
            clearFile();
            for(int i = 0;i<movies.size();i++) {
                buffW.write(""+movies.get(i).getId()+" "+movies.get(i).getYear()+" "+movies.get(i).getMovieTitle()+" "+movies.get(i).getLink()+" "+movies.get(i).getGenre()+" "+movies.get(i).getDuration()+" "+movies.get(i).getPictureLink()+""+"\n");
            }
            buffW.close();
        }
        catch (Exception e) {
            System.out.println("Error in writing to file Movies.txt");
        }
    }

    public void testAddToArray() {
        movies.add(new Movies(9,9999,"Testting_test","http://blah","Genre","22:22","Http://test.dk"));
    }
}
