package com.example.makso.shopping_listopia.views.adapters;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.makso.shopping_listopia.R;
import com.example.makso.shopping_listopia.data.models.Article;
import com.example.makso.shopping_listopia.data.models.ShoppingList;

/**
 * Created by Makso on 4/28/2017.
 */

public class ArticlesCursorAdapter extends CursorAdapter{

    public ArticlesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =   LayoutInflater.from(context).inflate(R.layout.view_item_article, parent, false);
        ArticlesCursorAdapter.ViewHolder viewHolder  =   new ArticlesCursorAdapter.ViewHolder();
        viewHolder.name    =   (TextView)  view.findViewById(R.id.name);
        viewHolder.nameIndex   =   cursor.getColumnIndexOrThrow(Article.COLUMN_NAME);

        viewHolder.amount    =   (TextView)  view.findViewById(R.id.amount);
        viewHolder.amountIndex   =   cursor.getColumnIndexOrThrow(Article.COLUMN_AMOUNT);

        view.setTag(viewHolder);
        Log.d("CURSOR", "cursor je newView " + cursor.getPosition());
        return view;
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        Log.d("CURSOR", "cursor je BindView " + cursor.getPosition());
        ArticlesCursorAdapter.ViewHolder viewHolder  =   (ArticlesCursorAdapter.ViewHolder)    view.getTag();
        viewHolder.name.setText(cursor.getString(viewHolder.nameIndex));
        viewHolder.amount.setText(cursor.getString(viewHolder.amountIndex));
        Log.d("shoppingList", "Ime " + viewHolder.name.getText().toString());

    }

    private static class ViewHolder {

        private TextView name;
        private int nameIndex;
        private TextView amount;
        private int amountIndex;
    }

}
