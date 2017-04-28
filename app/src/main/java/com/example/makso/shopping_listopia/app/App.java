package com.example.makso.shopping_listopia.app;

import android.app.Application;
import android.content.Context;

import com.example.makso.shopping_listopia.data.DatabaseHelper;
import com.example.makso.shopping_listopia.data.DatabaseManager;

/**
 * Created by Makso on 4/27/2017.
 */

public class App extends Application {

    private static Context context;
    private static DatabaseHelper databaseHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        databaseHelper = new DatabaseHelper();
        DatabaseManager.initializeInstance(databaseHelper);

    }

    public static Context getContext(){
        return context;
    }
}
