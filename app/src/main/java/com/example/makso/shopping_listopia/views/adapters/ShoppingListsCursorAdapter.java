package com.example.makso.shopping_listopia.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makso.shopping_listopia.MainActivity;
import com.example.makso.shopping_listopia.R;
import com.example.makso.shopping_listopia.activities.ShoppingListActivity;
import com.example.makso.shopping_listopia.data.models.ShoppingList;

/**
 * Created by Makso on 4/26/2017.
 */

public class ShoppingListsCursorAdapter extends CursorAdapter  {

    public ShoppingListsCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =   LayoutInflater.from(context).inflate(R.layout.view_item_shopping_list, parent, false);
        ViewHolder viewHolder  =   new ViewHolder();
        viewHolder.name    =   (TextView)  view.findViewById(R.id.name);
        viewHolder.nameIndex   =   cursor.getColumnIndexOrThrow(ShoppingList.COLUMN_NAME);
        //view.setTag(viewHolder);
        //TextView name   =   (TextView)  view.findViewById(R.id.name);
        //name.setText(cursor.getColumnIndexOrThrow(ShoppingList.COLUMN_NAME));
        //viewHolder.name.setTag(viewHolder);
        //TextView name = (TextView)  view.findViewById(R.id.name);
        view.setTag(viewHolder);
        Log.d("CURSOR", "cursor je newView " + cursor.getPosition());
        return view;
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        Log.d("CURSOR", "cursor je BindView " + cursor.getPosition());
        ViewHolder viewHolder  =   (ViewHolder)    view.getTag();
        viewHolder.name.setText(cursor.getString(viewHolder.nameIndex));
       // TextView name = (TextView) view.getTag();
       // name.setText((cursor.getString(viewHolder.nameIndex));
        Log.d("shoppingList", "Ime " + viewHolder.name.getText().toString());
       /* viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int count = cursor.getCount();
                int position = cursor.getPosition();
                Log.d("COUNT", "COUNT " + count);
                Log.d("Position", "Position " + position);
                Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();


            }
        });*/

    }

    private static class ViewHolder {

        private TextView name;

        private int nameIndex;
    }

}
