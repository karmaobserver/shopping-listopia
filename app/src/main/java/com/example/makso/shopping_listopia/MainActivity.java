package com.example.makso.shopping_listopia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;

import com.example.makso.shopping_listopia.activities.ShoppingListActivity;
import com.example.makso.shopping_listopia.data.DatabaseHelper;
import com.example.makso.shopping_listopia.data.DatabaseManager;
import com.example.makso.shopping_listopia.data.InitData;
import com.example.makso.shopping_listopia.data.models.Article;
import com.example.makso.shopping_listopia.data.models.ShoppingList;
import com.example.makso.shopping_listopia.data.repos.ArticleRepo;
import com.example.makso.shopping_listopia.data.repos.ShoppingListRepo;
import com.example.makso.shopping_listopia.views.adapters.ShoppingListsCursorAdapter;
import com.example.makso.shopping_listopia.views.dialogs.AddShoppingListDialogFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ShoppingListsCursorAdapter adapter;

    Cursor cursor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Display icon in the toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Initzialize data
        InitData initData = new InitData();
        initData.insertSampleData();

        // Getting All ShoppingLists (I used it only to test database for first time, i use cursorAdapter now)
        readingShoppingLists();

        //Attach adapter on ListView with ShoppingLists
        ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
        Cursor cursor = shoppingListRepo.getShoppingListsCursor();
        adapter = new ShoppingListsCursorAdapter(this, cursor, 0);
        /*ShoppingListsCursorAdapter adapter = new ShoppingListsCursorAdapter(
                this, R.layout.view_item_shopping_list, cursor, 0 );*/

        ListView listView = (ListView) findViewById(R.id.listViewShoppingLists);
        listView.setAdapter(adapter);
        //listView.setClickable(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("KONACNI", "JEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE: ");
                ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
                //Cursor cursor = shoppingListRepo.getShoppingListsCursor();
                Cursor cursor;
                cursor = shoppingListRepo.retrieveRow(id);

                Log.d("KONACNI", "qwe: " + cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_ID)));

                int idShoppingList = cursor.getInt(cursor.getColumnIndex(ShoppingList.COLUMN_ID));
                Intent shoppingListIntent = new Intent(view.getContext(), ShoppingListActivity.class);
                shoppingListIntent.putExtra("idShoppingList", idShoppingList);
                //startActivityForResult(shoppingListIntent, 0);
                startActivity(shoppingListIntent);
            }
        });
        //DatabaseManager.getInstance().closeDatabase();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_shopping_list:
                // User chose the "Settings" item, show the app settings UI...
                DialogFragment newFragment = new AddShoppingListDialogFragment();
                newFragment.show(getSupportFragmentManager(), "Add Shopping list");

                return true;

            case R.id.action_edit_shopping_list_home:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void readingShoppingLists() {

        // Reading all ShoppingLists
        Log.d("Reading: ", "Reading all ShoppingLists..");
        ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
        List<ShoppingList> shops = shoppingListRepo.getAllShops();

        for (ShoppingList shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Done: " + shop.isDone() +" ,Password: " + shop.getPassword();
        // Writing ShoppingLists to log
            Log.d("ShoppingLists: : ", log);
        }

    }



}
