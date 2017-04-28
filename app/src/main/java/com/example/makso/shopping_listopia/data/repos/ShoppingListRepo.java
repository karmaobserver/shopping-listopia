package com.example.makso.shopping_listopia.data.repos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.makso.shopping_listopia.data.DatabaseManager;
import com.example.makso.shopping_listopia.data.models.ShoppingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makso on 4/27/2017.
 */

public class ShoppingListRepo {

    private ShoppingList shoppingList;

    public ShoppingListRepo(){

        shoppingList= new ShoppingList();

    }


    public static String createTable(){
        return "CREATE TABLE " + ShoppingList.TABLE  + "("
                + ShoppingList.COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ShoppingList.COLUMN_DONE + " INTEGER,"
                + ShoppingList.COLUMN_PASSWORD + " TEXT,"
                + ShoppingList.COLUMN_NAME + " TEXT)";
    }


    public int insert(ShoppingList shoppingList) {
        int shoppingListId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        Log.d("ID", "ID JE: " + shoppingList.getId());
        //values.put(ShoppingList.COLUMN_ID, shoppingList.getId());
        values.put(ShoppingList.COLUMN_NAME, shoppingList.getName());
        values.put(ShoppingList.COLUMN_DONE, shoppingList.isDone());
        values.put(ShoppingList.COLUMN_PASSWORD, shoppingList.getPassword());

        // Inserting Row
        shoppingListId =(int)db.insert(ShoppingList.TABLE, null, values);

        DatabaseManager.getInstance().closeDatabase();
        Log.d("BAZE", "BAZE JE: " + shoppingListId);
        return shoppingListId;
    }

    public Cursor retrieveRow(long rowId) {
        String[] resultColumns = new String[] {ShoppingList.COLUMN_NAME, ShoppingList.COLUMN_PASSWORD, ShoppingList.COLUMN_ID};
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor row = db.query(true,ShoppingList.TABLE, resultColumns, ShoppingList.COLUMN_ID +"=" +rowId, null, null, null, null,null);
        if(row != null){
            row.moveToFirst();
        }
        DatabaseManager.getInstance().closeDatabase();
        return row;
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(ShoppingList.TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }

    // Get All ShoppingLists Cursor
    public Cursor getShoppingListsCursor() {
        String selectQuery = "SELECT * FROM " + ShoppingList.TABLE;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
       // DatabaseManager.getInstance().closeDatabase();    Don't forget to close connection
        return cursor;
    }

    // Get by Id ShoppingLists Cursor
    public ShoppingList getShoppingListByIdCursor(int id) {

        String selectQuery = "SELECT * FROM " + ShoppingList.TABLE + " WHERE " + ShoppingList.COLUMN_ID + " IN (" + id +")";
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Log.d("QUERY", "there " + selectQuery);
        Cursor cursor = db.rawQuery(selectQuery, null);

        ShoppingList shoppingList = new ShoppingList();

        if (cursor.moveToFirst()) {
            do {

                //shoppingList.setId(cursor.getColumnIndex(ShoppingList.COLUMN_ID));
                shoppingList.setName(cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_NAME)));
                shoppingList.setPassword(cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_PASSWORD)));
                boolean value = cursor.getInt(cursor.getColumnIndex(ShoppingList.COLUMN_DONE)) > 0;
                shoppingList.setDone(value);
                // Adding contact to list

            } while (cursor.moveToNext());
        }
        DatabaseManager.getInstance().closeDatabase();
        return shoppingList;
    }

    // Getting All ShoppingLists (I used it only to test database for first time)
    public List<ShoppingList> getAllShops() {
        List<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + ShoppingList.TABLE;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ShoppingList shoppingList = new ShoppingList();
                //shoppingList.setId(cursor.getColumnIndex(ShoppingList.COLUMN_ID));
                shoppingList.setName(cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_NAME)));
                shoppingList.setPassword(cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_PASSWORD)));
                boolean value = cursor.getInt(cursor.getColumnIndex(ShoppingList.COLUMN_DONE)) > 0;
                shoppingList.setDone(value);
        // Adding contact to list
                shoppingLists.add(shoppingList);
            } while (cursor.moveToNext());
        }
        // return contact list
        DatabaseManager.getInstance().closeDatabase();
        return shoppingLists;
    }
}
