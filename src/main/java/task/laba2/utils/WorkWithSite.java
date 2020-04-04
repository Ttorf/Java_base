package task.laba2.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import task.laba2.models.*;

import java.util.Objects;

public class WorkWithSite {


    public String JsonToString(People people) throws UnirestException {
        people = new People();
        people.setResponse((Unirest.get(people.getUrl()).asJson()));
        return people.getResponse().getBody().toString();
    }

    public String JsonToString(People people, String url) throws UnirestException {
        people = new People();
        people.setResponse((Unirest.get(url).asJson()));
        return people.getResponse().getBody().toString();
    }

    public String JsonToString(Films film) throws UnirestException {
        film = new Films();
        film.setResponse((Unirest.get(film.getUrl()).asJson()));
        return film.getResponse().getBody().toString();
    }

    public String JsonToString(Films film, String url) throws UnirestException {
        film = new Films();
        film.setResponse((Unirest.get(url).asJson()));
        return film.getResponse().getBody().toString();
    }

    public String JsonToString(Planet planet) throws UnirestException {
        planet = new Planet();
        planet.setResponse((Unirest.get(planet.getUrl()).asJson()));
        return planet.getResponse().getBody().toString();
    }

    public String JsonToString(Planet planet, String url) throws UnirestException {
        planet = new Planet();
        planet.setResponse((Unirest.get(url).asJson()));
        return planet.getResponse().getBody().toString();
    }

    public String JsonToString(Species species) throws UnirestException {
        species = new Species();
        species.setResponse((Unirest.get(species.getUrl()).asJson()));
        return species.getResponse().getBody().toString();
    }

    public String JsonToString(Species species, String url) throws UnirestException {
        species = new Species();
        species.setResponse((Unirest.get(url).asJson()));
        return species.getResponse().getBody().toString();
    }

    public String JsonToString(Starship starship) throws UnirestException {
        starship = new Starship();
        starship.setResponse((Unirest.get(starship.getUrl()).asJson()));
        return starship.getResponse().getBody().toString();
    }

    public String JsonToString(Starship starship, String url) throws UnirestException {
        starship = new Starship();
        starship.setResponse((Unirest.get(url).asJson()));
        return starship.getResponse().getBody().toString();
    }

    public String JsonToString(Vehicles vehicles) throws UnirestException {
        vehicles = new Vehicles();
        vehicles.setResponse((Unirest.get(vehicles.getUrl()).asJson()));
        return vehicles.getResponse().getBody().toString();
    }

    public String JsonToString(Vehicles vehicles, String url) throws UnirestException {
        vehicles = new Vehicles();
        vehicles.setResponse((Unirest.get(url).asJson()));
        return vehicles.getResponse().getBody().toString();
    }
}
