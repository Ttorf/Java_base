package task.laba2.models;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface Client<T> {
    T getPeopleByName(String name) throws UnirestException;

    T getPeopleByID(int id) throws UnirestException;

    T getAllPeople() throws UnirestException;

    T getPlanetByName(String name) throws UnirestException;

    T getPlanetByID(int id) throws UnirestException;

    T getAllPlanets() throws UnirestException;

    T getFilmByTitle(String title) throws UnirestException;

    T getFilmByID(int id) throws UnirestException;

    T getAllFilms() throws UnirestException;

    T getSpeciesByName(String name) throws UnirestException;

    T getSpeciesByID(int id) throws UnirestException;


    T getAllSpecies() throws UnirestException;

    T getVehicleByName(String name) throws UnirestException;

    T getVehicleByID(int id) throws UnirestException;

    T getAllVehicles() throws UnirestException;

    T getStarshipByName(String name) throws UnirestException;

    T getStarshipByID(int id) throws UnirestException;

    T getAllStarships() throws UnirestException;

    T getByUrl(String url, T type) throws UnirestException;

    T getAllPage(String url, T type);

    T getOnePage(String jsonStr, T type);

}
