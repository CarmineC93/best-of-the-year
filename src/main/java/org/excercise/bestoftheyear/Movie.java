package org.excercise.bestoftheyear;

public class Movie {
    //ATTRIBUTES
    private String name;
    private int id;
    //CONSTRUCTOR
    public Movie(int id, String name) {
        this.id = id;
        this.name= name;
    }
    //GETTER E SETTER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
