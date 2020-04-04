package task.laba2;


import com.mashape.unirest.http.exceptions.UnirestException;
import task.laba2.models.*;
import task.laba2.utils.ClientImplementation;
import task.laba2.utils.WorkWithPeople;

import java.util.List;

public class Test {
    static WorkWithPeople workWithPersonData;

    public static void main(String[] args) throws UnirestException {
        ClientImplementation clientImplementation = new ClientImplementation();
        String name = "Leia Organa";
        People people = new People();
        Films films = new Films();
        Planet planet = new Planet();
        Species species = new Species();
        Starship starship = new Starship();
        Vehicles vehicles = new Vehicles();

//        People people2 = clientImplementation.getPeopleByName(name);
//   System.out.println(people2.getMass());
//   people = clientImplementation.getPeopleByID(9);
//        System.out.println(people2.getName());
//
//
//        String title = "Attack of the Clones";
//        Films films = clientImplementation.getFilmByTitle(title);
//        System.out.println(films.getEpisode_id());
//
//        String namepl = "Hoth";
//        Planet planet = clientImplementation.getPlanetByName(namepl);
//        System.out.println(planet.getGravity());

        List<People> peopleList = clientImplementation.getByUrl("http://swapi.co/api/people/1", people);
        List<Films> filmsList = clientImplementation.getByUrl("http://swapi.co/api/films/", films);
        System.out.println();
        System.out.println(peopleList);
        for(People people1:peopleList)
        {
            System.out.println(people1);
        }


    }


}
