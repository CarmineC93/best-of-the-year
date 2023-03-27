package org.excercise.bestoftheyear;

public class Song {
    //ATTRIBUTES
    private String name;
    private int id;

    //CONTRUCTORS

    public Song(int id, String name) {
        this.name = name;
        this.id = id;
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
