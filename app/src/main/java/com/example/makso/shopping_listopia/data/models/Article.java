package com.example.makso.shopping_listopia.data.models;

/**
 * Created by Makso on 4/26/2017.
 */

public class Article {

    public static final String TAG = Article.class.getSimpleName();
    public static final String TABLE = "Article";

    // Labels Table Columns names
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DONE = "done";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_SP_ID = "sp_id";

    private int id;
    private String name;
    private Integer amount;
    private boolean done;
    private int sp_id;

    public Article() {
    }

    public Article(int id, String name, Integer amount, boolean done, int sp_id) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.done = done;
        this.sp_id = sp_id;
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

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }
}
