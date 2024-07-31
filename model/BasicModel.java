package model;

public abstract class BasicModel {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void print() {
        System.out.println("print content in console");
    }
}
