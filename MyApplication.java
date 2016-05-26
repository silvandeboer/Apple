package atlas.apple;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silvan on 24.05.2016.
 * This activity stands on top of other activities. The database is initiated in here so any activity can
 * access it at any time. To see how, look in the Recipe class.
 */
public class MyApplication extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //TODO: Silvan tries something out
    public DatabaseHandler recipeTable;

    @Override
    public void onCreate() {
        super.onCreate();

        //create the recipes in the database table
        //DatabaseHandler recipeTable = new DatabaseHandler(this);
        recipeTable = new DatabaseHandler(this);
        createData(recipeTable);

        //put all recipes in a list
        Log.d("Reading: ", "Reading all contacts..");
        List<RecipeData> recipes = recipeTable.getAllRecipes();

        //Write all recipes in the log
        for (RecipeData cn : recipes) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Type: " + cn.getType();
            Log.d("Recipe: ", log);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    void createData(DatabaseHandler dbHandler) {

        //clear table
        for (RecipeData r : dbHandler.getAllRecipes()) {
            dbHandler.deleteRecipe(r);
        }

        //Write the recipes here.
        //TODO: make a table as resource file
        List<RecipeData> rc_burger = new ArrayList<RecipeData>();
        rc_burger.add(new RecipeData("Burger",
                "Meat+",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the massive piece of meat.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2", "3", "2", "1", "2", "3", "2"));
        rc_burger.add(new RecipeData("Burger",
                "Meat",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the meat.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2", "3", "2", "1", "2", "3", "2"));
        rc_burger.add(new RecipeData("Burger",
                "Vegetarian",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the vegetables.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2", "3", "2", "1", "2", "3", "2"));
        rc_burger.add(new RecipeData("Burger",
                "Vegan",
                "1000g vegetables5mL water1 grain of salt",
                "1. Take the vegetables.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2", "3", "2", "1", "2", "3", "2"));
        dbHandler.addRecipeComplete(rc_burger);
    }

}
