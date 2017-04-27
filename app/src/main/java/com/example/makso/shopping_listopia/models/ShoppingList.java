package com.example.makso.shopping_listopia.models;

/**
 * Created by Makso on 4/26/2017.
 */

public class ShoppingList {

    private Long id;
    private String name;
    private boolean done;
    private String password;

    public ShoppingList() {
    }

    public ShoppingList(Long id, String name, boolean done, String password) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
