package com.example.makso.shopping_listopia.data.models;

/**
 * Created by Makso on 4/26/2017.
 */

public class ShoppingList {

    public static final String TAG = ShoppingList.class.getSimpleName();
    public static final String TABLE = "ShoppingList";

    // Labels Table Columns names
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DONE = "done";
    public static final String COLUMN_PASSWORD = "password";

    private int id;
    private String name;
    private boolean done;
    private String password;

    public ShoppingList() {
    }

    public ShoppingList(int id, String name, boolean done, String password) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
