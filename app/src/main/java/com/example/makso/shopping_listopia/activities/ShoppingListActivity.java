package com.example.makso.shopping_listopia.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.makso.shopping_listopia.R;
import com.example.makso.shopping_listopia.data.models.ShoppingList;
import com.example.makso.shopping_listopia.data.repos.ArticleRepo;
import com.example.makso.shopping_listopia.data.repos.ShoppingListRepo;
import com.example.makso.shopping_listopia.views.adapters.ArticlesCursorAdapter;
import com.example.makso.shopping_listopia.views.adapters.ShoppingListsCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makso on 4/26/2017.
 */

public class ShoppingListActivity extends AppCompatActivity {

    private ArticlesCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent shoppingListIntent = getIntent();
        int idShoppingList = shoppingListIntent.getIntExtra("idShoppingList", 0);

        Log.d("DRUGA", "STRANA id je" + idShoppingList);

        ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
        ShoppingList shoppingList = shoppingListRepo.getShoppingListByIdCursor(idShoppingList);

        Log.d("Dobijen", "od query " + shoppingList.getName());

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(shoppingList.getName());

        //Attach adapter on ListView with Articles
       /* ArticleRepo articleRepo = new ArticleRepo();
        Cursor cursor = articleRepo.getArticlesByShoppingListId(idShoppingList);
        adapter = new ArticlesCursorAdapter(this, cursor, 0);

        ListView listView = (ListView) findViewById(R.id.listViewShoppingLists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("KONACNI", "JEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE: ");
                ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
                Cursor cursor = shoppingListRepo.getShoppingListsCursor();
                cursor = shoppingListRepo.retrieveRow(id);

                Log.d("KONACNI", "qwe: " + cursor.getString(cursor.getColumnIndex(ShoppingList.COLUMN_ID)));

                int idShoppingList = cursor.getInt(cursor.getColumnIndex(ShoppingList.COLUMN_ID));
                Intent shoppingListIntent = new Intent(view.getContext(), ShoppingListActivity.class);
                shoppingListIntent.putExtra("idShoppingList", idShoppingList);
                //startActivityForResult(shoppingListIntent, 0);
                startActivity(shoppingListIntent);
            }
        });*/



    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_list, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
