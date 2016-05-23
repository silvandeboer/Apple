package atlas.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler recipeTable = new DatabaseHandler(this);

        createData(recipeTable);


        String lst = "";
        List<RecipeData> recipes = recipeTable.getAllRecipes();

        for (RecipeData r : recipes){
            lst+=r.getName()+"\n";
        }

        TextView recipe_list = (TextView) findViewById(R.id.recipeList);
        recipe_list.setText(lst);

    }

    void createData(DatabaseHandler dbHandler){

        //clear table
        //for (RecipeData r : dbHandler.getAllRecipes()){
        //    dbHandler.deleteRecipe(r);
        //}

        //Write the recipes here
        //TODO: make a table as resource file
        //List<RecipeData> rc_burger = new ArrayList<RecipeData>();
        //rc_burger.add(new RecipeData("Burger+", "Lekker hoor"));
        //rc_burger.add(new RecipeData("Burger", "Lekker hoor, maar minder vlees"));
        //rc_burger.add(new RecipeData("Burger-", "Lekker hoor, maar zonder vlees"));
        //rc_burger.add(new RecipeData("Burger--", "Gatverdamme kut! wat de fak is deze smerige poepzooi?!?"));

        //add the recipes to the table
        //dbHandler.addRecipeComplete(rc_burger);

        RecipeData rcburger1 = new RecipeData("Burger",
                "Vegetarian",
                "10g vegetables5mL water1 grain of salt",
                "1. Take the vegetables.2. Combine them.3. Add the rest.4. Eat!",
                "American|Lunch",
                "imageref",
                2,3,2,1,2,3,2);
        dbHandler.addRecipe(rcburger1);
    }
}
