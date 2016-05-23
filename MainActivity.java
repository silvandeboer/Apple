package atlas.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the recipes in the database table
        DatabaseHandler recipeTable = new DatabaseHandler(this);
        createData(recipeTable);

        //put all recipes in a list
        Log.d("Reading: ", "Reading all contacts..");
        List<RecipeData> recipes = recipeTable.getAllRecipes();

        //Write all recipes in the log
        for (RecipeData cn : recipes) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Type: " + cn.getType();
            Log.d("Recipe: ", log);
        };

        //Write all recipes in the activity (FOR DEMO PURPOSES ONLY)
        String lst = "";
        for (RecipeData r : recipes){
            lst+=r.getName()+" ("+r.getType()+")\n";
        }
        TextView recipe_list = (TextView) findViewById(R.id.recipeList);
        recipe_list.setText(lst);

    }

    void createData(DatabaseHandler dbHandler){

        //clear table
        for (RecipeData r : dbHandler.getAllRecipes()){
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
                "2","3","2","1","2","3","2"));
        rc_burger.add(new RecipeData("Burger",
                "Meat",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the meat.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2","3","2","1","2","3","2"));
        rc_burger.add(new RecipeData("Burger",
                "Vegetarian",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the vegetables.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2","3","2","1","2","3","2"));
        rc_burger.add(new RecipeData("Burger",
                "Vegan",
                "1000g vegetables5mL water1 grain of salt",
                "1. Take the vegetables.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                "2","3","2","1","2","3","2"));
        dbHandler.addRecipeComplete(rc_burger);
    }
}
