package tree;

import java.util.ArrayList;

/**
 * This class represents the movie template.
 * Each object of this class contains the data from the sheet where each object is an entry.
 * The following is a list of all parameters:-
 *
 * Id: represents the IMDB movie Id
 * title: represents the movie title
 * yearOfRelease: represents the year on which the movie was released
 * genre: represents all the genre to which the movie belong to
 * duration: represents the duration of the movie in minutes
 * language: represents the language in which the movie was originally released
 * directors: holds up to two primary directors of the movie
 * actors: holds the two primary actors
 * averageVotes: is the average vote of the movie
 * votes: represent the total number of votes received for the movie
 *
 * @author Shadab Khan
 *
 */
public class Movie {
    private String id;
    private String title;
    private int yearOfRelease;
    private ArrayList<String> genre;
    private int duration;
    private String language;
    private ArrayList<String> directors;
    private ArrayList<String> actors;
    private float averageVotes;
    private int votes;

    /**Constructs the movie object**/
    public Movie() {
        this.genre = new ArrayList<String>();
        this.directors = new ArrayList<String>();
        this.actors = new ArrayList<String>();
    }

    /**
     * accessor method for the movie Id
     * @return movie Id as id
     */
    public String getId() {
        return id;
    }

    /**
     * mutator method for the movie Id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * accessor method for the movie title
     * @return movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * mutator method for the movie title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * accessor method for the year of release of the movie
     * @return year of release of the movie
     */
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     * mutator method for the year of release
     * @param yearOfRelease
     */
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     * accessor method for the genre
     * @return genres of the movie
     */
    public ArrayList<String> getGenre() {
        return genre;
    }

    /**
     * mutator method for the movie genre
     * @param genre list
     */
    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    /**
     * accessor method for the duration of the movie
     * @return duration of the movie
     */
    public int getDuration() {
        return duration;
    }

    /**
     * mutator method for the movie duration
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * accessor method for the language of the movie
     * @return the language of the movie
     */
    public String getLanguage() {
        return language;
    }

    /**
     * mutator method for the movie language
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * accessor method for the directors of the movie
     * @return list of directors
     */
    public ArrayList<String> getDirectors() {
        return directors;
    }

    /**
     * mutator method for the list of movie directors
     * @param directors list
     */
    public void setDirectors(ArrayList<String> directors) {
        this.directors = directors;
    }

    /**
     * adds a director to the list of directors
     * @param director
     */
    public void addDirectors(String director) {
        this.directors.add(director);
    }

    /**
     * accessor method for the actors of the movie
     * @return list of actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * mutator method for the list of movie actors
     * @param actors list
     */
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * adds an actor to the list of actors
     * @param actor
     */
    public void addActors(String actor) {
        this.actors.add(actor);
    }

    /**
     * accessor method for the average votes of the movie
     * @return the average votes of the movie
     */
    public float getAverageVotes() {
        return averageVotes;
    }

    /**
     * mutator method for the average votes
     * @param averageVotes
     */
    public void setAverageVotes(float averageVotes) {
        this.averageVotes = averageVotes;
    }

    /**
     * accessor method for the number of votes received for the movie
     * @return the number of votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * mutator method for the number of votes
     * @param votes
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * Produces a string representation of the contents of a list
     * @param list of string elements
     * @return textual representation of the list
     */
    private String arrayListToString(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }

        String result = "[ ";
        for (String s : list) {
            result = result + s + ", ";
        }
        result = result.trim();
        result = result.substring(0, result.length() - 1) + " ]";
        return result;
    }

    /**
     * Produces a string representation of the movie.
     * @return textual representation of the movie
     */
    public String toString() {
        String genre = arrayListToString(getGenre());
        String directors = arrayListToString(getDirectors());
        String actors = arrayListToString(getActors());
        return "MovieId : " + getId() + "\tTitle : " + getTitle() + "\tYear of release : " + getYearOfRelease()
                + "\nGenre : " + genre + "\tLanguage : " + getLanguage() + "\tDirectors : " + directors + ",\nActors : "
                + actors + "\nAverage votes : " + getAverageVotes() + "\nTotal voters : " + getVotes();
    }

}

