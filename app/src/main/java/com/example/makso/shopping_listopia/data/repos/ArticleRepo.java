package com.example.makso.shopping_listopia.data.repos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.makso.shopping_listopia.data.DatabaseManager;
import com.example.makso.shopping_listopia.data.models.Article;
import com.example.makso.shopping_listopia.data.models.ShoppingList;

/**
 * Created by Makso on 4/27/2017.
 */

public class ArticleRepo {

    private Article article;

    public ArticleRepo(){

        article= new Article();

    }


    public static String createTable(){
        return "CREATE TABLE " + Article.TABLE  + "("
                + Article.COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Article.COLUMN_DONE + " TEXT,"
                + Article.COLUMN_AMOUNT + " TEXT,"
                + Article.COLUMN_SP_ID + " TEXT,"
                + Article.COLUMN_NAME + " TEXT)";
    }


    public int insert(Article article) {
        int articleId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        //values.put(Article.COLUMN_ID, article.getId());
        values.put(Article.COLUMN_NAME, article.getName());
        values.put(Article.COLUMN_DONE, article.isDone());
        values.put(Article.COLUMN_AMOUNT, article.getAmount());
        values.put(Article.COLUMN_SP_ID, article.getSp_id());

        // Inserting Row
        articleId =(int)db.insert(Article.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return articleId;
    }

    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(Article.TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    // getArticlesByShoppingListId Cursor
    public Cursor getArticlesByShoppingListId(int id) {
        String selectQuery =  " SELECT Article." + Article.COLUMN_ID
                + ", Article." + Article.COLUMN_NAME
                + ", Article." + Article.COLUMN_AMOUNT
                + ", ShoppingList." + ShoppingList.COLUMN_NAME
                + ", COUNT('') AS Total"
                + " FROM " + ShoppingList.TABLE
                + " INNER JOIN " + Article.TABLE + " Article ON Article." + Article.COLUMN_ID + "=  ShoppingList." + ShoppingList.COLUMN_ID
                + " GROUP BY Article." + Article.COLUMN_SP_ID + ", Article." + Article.COLUMN_NAME
                + " ORDER BY Article." + Article.COLUMN_NAME
                ;

        Log.d("Articles", "by id quert" + selectQuery);
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // DatabaseManager.getInstance().closeDatabase();    Don't forget to close connection
        return cursor;
    }

    public Cursor retrieveRow(long rowId) {
        String[] resultColumns = new String[] {Article.COLUMN_NAME, Article.COLUMN_AMOUNT, Article.COLUMN_ID};
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor row = db.query(true,Article.TABLE, resultColumns, Article.COLUMN_ID +"=" +rowId, null, null, null, null,null);
        if(row != null){
            row.moveToFirst();
        }
        DatabaseManager.getInstance().closeDatabase();
        return row;
    }
}
