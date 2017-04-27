package com.example.makso.shopping_listopia.models;

/**
 * Created by Makso on 4/26/2017.
 */

public class Article {

    private Long id;
    private String name;
    private Integer amount;
    private boolean done;

    public Article() {
    }

    public Article(Long id, String name, Integer amount, boolean done) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.done = done;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
