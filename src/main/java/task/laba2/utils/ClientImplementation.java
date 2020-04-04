package task.laba2.utils;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import task.laba2.models.*;

import java.util.List;

public class ClientImplementation<T> implements Client {
    People people;
    Films films;
    Planet planet;
    Species species;
    Starship starship;
    Vehicles vehicles;
    WorkWithSite workWithSite = new WorkWithSite();
    Gson gson = new Gson();
    String json;

    @Override
    public People getPeopleByName(String name) throws UnirestException {
        json = workWithSite.JsonToString(people);
        people = gson.fromJson(json, People.class);
        for (People per : people.getResults()) {
            if (per.getName().equals(name)) {
                return per;
            }
        }
        return null;

    }

    @Override
    public People getPeopleByID(int id) throws UnirestException {

        json = workWithSite.JsonToString(people);
        people = gson.fromJson(json, People.class);
        if (!people.getResults().isEmpty()) {
            return people.getResults().get(id);
        } else return null;
    }

    @Override
    public List<People> getAllPeople() throws UnirestException {
        json = workWithSite.JsonToString(people);
        people = gson.fromJson(json, People.class);
        return people.getResults();
    }

    @Override
    public Planet getPlanetByName(String name) throws UnirestException {
        json = workWithSite.JsonToString(planet);
        planet = gson.fromJson(json, Planet.class);
        for (Planet planet : planet.getResults()) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    @Override
    public Planet getPlanetByID(int id) throws UnirestException {
        json = workWithSite.JsonToString(planet);
        planet = gson.fromJson(json, Planet.class);
        if (!planet.getResults().isEmpty()) {
            return planet.getResults().get(id);
        } else return null;
    }

    @Override
    public List<Planet> getAllPlanets() throws UnirestException {
        json = workWithSite.JsonToString(planet);
        planet = gson.fromJson(json, Planet.class);
        return planet.getResults();
    }

    @Override
    public Films getFilmByTitle(String title) throws UnirestException {
        json = workWithSite.JsonToString(films);
        films = gson.fromJson(json, Films.class);
        for (Films films : films.getResults()) {
            if (films.getTitle().equals(title)) {
                return films;
            }
        }
        return null;
    }

    @Override
    public Films getFilmByID(int id) throws UnirestException {
        json = workWithSite.JsonToString(films);
        films = gson.fromJson(json, Films.class);
        if (!films.getResults().isEmpty()) {
            return films.getResults().get(id);
        } else return null;
    }

    @Override
    public List<Films> getAllFilms() throws UnirestException {
        json = workWithSite.JsonToString(films);
        films = gson.fromJson(json, Films.class);
        return films.getResults();
    }

    @Override
    public Species getSpeciesByName(String name) throws UnirestException {
        json = workWithSite.JsonToString(species);
        species = gson.fromJson(json, Species.class);
        for (Species species : species.getResults()) {
            if (species.getName().equals(name)) {
                return species;
            }
        }
        return null;
    }

    @Override
    public Species getSpeciesByID(int id) throws UnirestException {
        json = workWithSite.JsonToString(species);
        species = gson.fromJson(json, Species.class);
        if (!species.getResults().isEmpty()) {
            return species.getResults().get(id);
        } else return null;
    }

    @Override
    public List<Species> getAllSpecies() throws UnirestException {
        json = workWithSite.JsonToString(species);
        species = gson.fromJson(json, Species.class);
        return species.getResults();
    }

    @Override
    public Vehicles getVehicleByName(String name) throws UnirestException {
        json = workWithSite.JsonToString(vehicles);
        vehicles = gson.fromJson(json, Vehicles.class);
        for (Vehicles vehicles : vehicles.getResults()) {
            if (vehicles.getName().equals(name)) {
                return vehicles;
            }
        }
        return null;
    }

    @Override
    public Vehicles getVehicleByID(int id) throws UnirestException {
        json = workWithSite.JsonToString(vehicles);
        vehicles = gson.fromJson(json, Vehicles.class);
        if (!vehicles.getResults().isEmpty()) {
            return vehicles.getResults().get(id);
        } else return null;
    }

    @Override
    public List<Vehicles> getAllVehicles() throws UnirestException {
        json = workWithSite.JsonToString(vehicles);
        vehicles = gson.fromJson(json, Vehicles.class);
        return vehicles.getResults();
    }

    @Override
    public Starship getStarshipByName(String name) throws UnirestException {
        json = workWithSite.JsonToString(starship);
        starship = gson.fromJson(json, Starship.class);
        for (Starship starship : starship.getResults()) {
            if (starship.getName().equals(name)) {
                return starship;
            }
        }
        return null;
    }

    @Override
    public Starship getStarshipByID(int id) throws UnirestException {
        json = workWithSite.JsonToString(starship);
        starship = gson.fromJson(json, Starship.class);
        if (!starship.getResults().isEmpty()) {
            return starship.getResults().get(id);
        } else return null;
    }

    @Override
    public List<Starship> getAllStarships() throws UnirestException {
        json = workWithSite.JsonToString(starship);
        starship = gson.fromJson(json, Starship.class);
        return starship.getResults();
    }

    @Override
    public List<T> getByUrl(String url, Object type) throws UnirestException {
        People people = new People();
        Films films = new Films();
        Planet planet = new Planet();
        Species species = new Species();
        Starship starship = new Starship();
        Vehicles vehicles = new Vehicles();
        if (type.getClass() == people.getClass()) {

            String json = workWithSite.JsonToString(people, url);
            this.people = gson.fromJson(json, People.class);
            return (List<T>) this.people.getResults();
        } else if (type.getClass() == films.getClass()) {
            String json = workWithSite.JsonToString(films, url);
            this.films = gson.fromJson(json, Films.class);
            return (List<T>) this.films.getResults();
        } else if (type.getClass().equals(planet.getClass())) {
            json = workWithSite.JsonToString(planet, url);
            this.planet = gson.fromJson(json, Planet.class);
            return (List<T>) this.planet.getResults();
        } else if (type.getClass().equals(species.getClass())) {
            json = workWithSite.JsonToString(species, url);
            this.species = gson.fromJson(json, Species.class);
            return (List<T>) this.species.getResults();
        } else if (type.getClass().equals(starship.getClass())) {
            json = workWithSite.JsonToString(starship, url);
            this.starship = gson.fromJson(json, Starship.class);
            return (List<T>) this.starship.getResults();
        } else if (type.getClass().equals(vehicles.getClass())) {
            json = workWithSite.JsonToString(vehicles, url);
            this.vehicles = gson.fromJson(json, Vehicles.class);
            return (List<T>) this.vehicles.getResults();
        } else {
            return null;
        }
    }

    @Override
    public List<T> getAllPage(String url, Object type) {
        return null;
    }

    @Override
    public Object getOnePage(String jsonStr, Object type) {
        return null;
    }


}
