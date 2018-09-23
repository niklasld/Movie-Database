package com.moviedb.moviedb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.apache.coyote.http11.Constants.A;


@Controller
public class MovieDBController {
    Logger log = Logger.getLogger(MovieDBController.class.getName());

    ArrayList<Movies> movies = new ArrayList<>();
    String test;

    int movieId;

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

   @GetMapping("/createMovie")
   public String create(Model model){
       log.info("create movie called");
       //log.fine("Index: 0-> "+movies.get(0));

       model.addAttribute("movie", movies.get(movieId));


       return "createMovie";
   }
    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        log.info("add movie called...");

        model.addAttribute("movie", movies.get(movieId));

        return "addMovie";
    }

    @GetMapping("/search")
    public String search(Model model){
        log.info("search called...");
        //log.fine("Index: 0-> "+movies.get(0));

        model.addAttribute("movie", movies);
        //model.addAttribute("test",test);
        log.info(test);

        return "searchMovie";
    }

    @GetMapping("/style")
    public String style(){
        return "style";
    }

    @GetMapping("/display")
    public String display(Model model){
        log.info("Display called");

        model.addAttribute("movie",movies.get(movieId));



      return "display";
    }

    /*@PostMapping(/addMovie)
    public void addMoviePostmatch(Long str1, Long str2, Long str3) {
        log.debug("found: {} and {} and {}", str1, str2, str3);
    }*/

    /*@GetMapping("/addMovie")
    public String addMovieForm(Model model){
        model.addAttribute("movie", new Movies());
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovieSubmit(@ModelAttribute Movies movies, Model model){

        userService.save(movies);
        model.addAttribute("students", userService.fetchAll());

        return "addMovie";
    }*/

    @RequestMapping(value = "/createMovie")
    public void movieToArrayList (@RequestParam("movieTitle")String movieTitle,
                                  @RequestParam("year")int year,
                                  @RequestParam("link")String link,
                                  @RequestParam("genre")String genre,
                                  @RequestParam("duration")String duration,
                                  @RequestParam("pictureLink")String pictureLink) throws Exception {

        log.info("requestmapping called");
        int id = movies.get(movies.size()-1).getId();
        id++;
        movies.add(new Movies(id,year,movieTitle,link,genre,duration,pictureLink));
        file.writeFile(movies);
        //return "99"+year+movieTitle+link+genre+duration+pictureLink;
    }

}