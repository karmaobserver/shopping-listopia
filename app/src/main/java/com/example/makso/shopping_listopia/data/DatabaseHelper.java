package com.example.makso.shopping_listopia.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.makso.shopping_listopia.app.App;
import com.example.makso.shopping_listopia.data.models.Article;
import com.example.makso.shopping_listopia.data.models.ShoppingList;
import com.example.makso.shopping_listopia.data.repos.ArticleRepo;
import com.example.makso.shopping_listopia.data.repos.ShoppingListRepo;

/**
 * Created by Makso on 4/27/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 42;
    // Database Name
    private static final String DATABASE_NAME = "listopia28.db";
    private static final String TAG = DatabaseHelper.class.getSimpleName().toString();

    public DatabaseHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here
        Log.d("ASDADADAAD", "SQLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL: ");
        db.execSQL(ShoppingListRepo.createTable());
        db.execSQL(ArticleRepo.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + ShoppingList.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Article.TABLE);
        onCreate(db);
    }
}
