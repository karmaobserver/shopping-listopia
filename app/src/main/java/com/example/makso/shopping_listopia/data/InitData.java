package com.example.makso.shopping_listopia.data;

import android.util.Log;

import com.example.makso.shopping_listopia.data.models.Article;
import com.example.makso.shopping_listopia.data.models.ShoppingList;
import com.example.makso.shopping_listopia.data.repos.ArticleRepo;
import com.example.makso.shopping_listopia.data.repos.ShoppingListRepo;

/**
 * Created by Makso on 4/28/2017.
 */

public class InitData {

    public void insertSampleData() {

        ShoppingListRepo shoppingListRepo = new ShoppingListRepo();
        ArticleRepo articleRepo   = new ArticleRepo();

        shoppingListRepo.delete();
        articleRepo.delete();

        ShoppingList shoppingList = new ShoppingList();
        Article article = new Article();

        Log.d("CREATION", "Creating dummies");

        shoppingList.setName("Groceries");
        shoppingList.setPassword("qeqe");
        shoppingList.setDone(true);
        shoppingListRepo.insert(shoppingList);

        shoppingList.setName("Shoes");
        shoppingList.setPassword("zzzzz");
        shoppingList.setDone(false);
        shoppingListRepo.insert(shoppingList);

        shoppingList.setName("Birthsday Presents");
        shoppingList.setPassword("ttttttttt");
        shoppingList.setDone(false);
        shoppingListRepo.insert(shoppingList);

        shoppingList.setName("Music list");
        shoppingList.setPassword("music");
        shoppingList.setDone(true);
        shoppingListRepo.insert(shoppingList);

        shoppingList.setName("Cloth to buy list");
        shoppingList.setPassword("cloth");
        shoppingList.setDone(true);
        shoppingListRepo.insert(shoppingList);

        article.setName("Apple");
        article.setAmount(3);
        article.setDone(true);
        article.setSp_id(1);
        articleRepo.insert(article);

        article.setName("Eggs");
        article.setAmount(4);
        article.setDone(true);
        article.setSp_id(1);
        articleRepo.insert(article);

        article.setName("Bread");
        article.setAmount(4);
        article.setDone(true);
        article.setSp_id(1);
        articleRepo.insert(article);

        article.setName("Snickers");
        article.setAmount(2);
        article.setDone(true);
        article.setSp_id(2);
        articleRepo.insert(article);

        article.setName("Cake");
        article.setAmount(8);
        article.setDone(true);
        article.setSp_id(3);
        articleRepo.insert(article);

        article.setName("Glasses");
        article.setAmount(4);
        article.setDone(true);
        article.setSp_id(3);
        articleRepo.insert(article);


        article.setName("Ring");
        article.setAmount(1);
        article.setDone(true);
        article.setSp_id(3);
        articleRepo.insert(article);

        article.setName("Magnets");
        article.setAmount(2);
        article.setDone(true);
        article.setSp_id(4);
        articleRepo.insert(article);

        article.setName("Strings");
        article.setAmount(6);
        article.setDone(true);
        article.setSp_id(4);
        articleRepo.insert(article);

        article.setName("Nike Hat");
        article.setAmount(1);
        article.setDone(true);
        article.setSp_id(5);
        articleRepo.insert(article);

        article.setName("Socks");
        article.setAmount(10);
        article.setDone(true);
        article.setSp_id(5);
        articleRepo.insert(article);

        article.setName("Dark shirt QOTSA");
        article.setAmount(1);
        article.setDone(true);
        article.setSp_id(5);
        articleRepo.insert(article);

        article.setName("Red shirt EODM");
        article.setAmount(6);
        article.setDone(true);
        article.setSp_id(5);
        articleRepo.insert(article);


    }
}
