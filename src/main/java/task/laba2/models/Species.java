package task.laba2.models;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.util.List;

public class Species  {
    private String name;
    private String classification;
    private String designation;
    private String naverage_heightame;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String skin_average_lifespancolors;
    private String homeworld;
    private String language;
    private List<String> people;
    private List<String> films;
    private String created;
    private String edited;
    private String url = "http://swapi.co/api/species/";;
    private HttpResponse<JsonNode> response;
    private List<Species> results;

    public List<Species> getResults() {
        return results;
    }

    public void setResults(List<Species> results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNaverage_heightame() {
        return naverage_heightame;
    }

    public void setNaverage_heightame(String naverage_heightame) {
        this.naverage_heightame = naverage_heightame;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public String getSkin_average_lifespancolors() {
        return skin_average_lifespancolors;
    }

    public void setSkin_average_lifespancolors(String skin_average_lifespancolors) {
        this.skin_average_lifespancolors = skin_average_lifespancolors;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }


    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public void setResponse(HttpResponse<JsonNode> response) {
        this.response = response;
    }
}
