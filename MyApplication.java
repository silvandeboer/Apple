package atlas.apple;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
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
        rc_burger.add(new RecipeData("Double Beef Burger",
                "Meat+",
                "2 tablespoons vegetable oil\n" +
                        "2 large onions\n" +
                        "Kosher salt\n" +
                        "1/4 cup mayonnaise\n" +
                        "2 tablespoons ketchup\n" +
                        "1 tablespoon sweet pickle relish\n" +
                        "1/2 teaspoon white vinegar\n" +
                        "2 pounds ground beef chuck (preferably 60 percent lean\n" +
                        "4 hamburger buns, split\n" +
                        "1/4 cup sliced dill pickles\n" +
                        "3/4 cup shredded iceberg lettuce\n" +
                        "6 thin slices tomato\n" +
                        "Freshly ground pepper\n" +
                        "1/4 cup yellow mustard\n" +
                        "8 slices American cheese" ,
                "1. Heat the vegetable oil in a large skillet over medium-low heat. Add the onions and 3/4 teaspoon salt, cover and cook, stirring occasionally, until golden and soft, about 30 minutes. (If the onions brown too quickly, reduce the heat to low.)\n" +
                        "2. Uncover, increase the heat to medium high and continue to cook, stirring often, until caramelized, about 8 more minutes.\n" +
                        "3. Add 1/2 cup water to skillet, scraping up any browned bits from the bottom of the pan. Simmer, stirring, until the water evaporates, about 2 more minutes; transfer to a bowl and set aside. (The onions can be made up to 3 days ahead; cover and refrigerate, then reheat before using.)\n" +
                        "4. Mix the mayonnaise, ketchup, relish and vinegar in a bowl; set aside. Shape the beef into 8 patties, about 4 inches wide and 1/2 inch thick.\n" +
                        "5. Heat a griddle or skillet over medium heat; lightly brush with vegetable oil. Toast the buns on the griddle, split-side down. Spread each toasted bun bottom with about 1 tablespoon of the mayonnaise mixture, then top with a few pickles, some lettuce, 1 or 2 slices tomato and another dollop of the mayonnaise mixture; set aside. (Keep the griddle hot.)\n" +
                        "6. Season both sides of the patties with salt and pepper. Working in batches if necessary, put the patties on the griddle and cook 3 minutes. Spread about 1 1/2 teaspoons mustard on the uncooked side of each patty, then flip and top each with 1 slice cheese; continue cooking about 2 more minutes for medium doneness. Top 4 of the patties with caramelized onions, then cover with the remaining patties, cheese-side up. Sandwich the double patties on the buns.",
                "American|Lunch",
                Integer.toString(R.drawable.hamburger_meat_plus),
                "1", "3", "2", "1", "2", "3", "2"));


        rc_burger.add(new RecipeData("Classic Burger",
                "Meat",
                "1/4 pound ground lean beef (7% fat)\n" +
                        "1/4 large egg\n" +
                        "1/8 cup minced onion\n" +
                        "1/4 spoon Worcestershire\n" +
                        "1/2 glove of garlic, peeled and minced\n" +
                        "about 1/8 tablespoon of salt\n" +
                        "about 1/16 tablespoon of pepper\n" +
                        "1 hamburger bun, split\n" +
                        "about 1/16 cup of mayonnaise\n" +
                        "about 1/16 cup of ketchup\n" +
                        "1 iceberg lettuce leaf, rinsed and crisped\n" +
                        "1/4 firm ripe tomato, cored and thinly sliced\n" +
                        "1 thin slice of red onion\n",
                "1. In abowl, mix ground beef, egg, onion, bread crumbs, Worcestershire, garlic, salt and pepper until well blended. Divide mxture into equal portions and shape each into a patty about 4 inches wide.\n" +
                        "2. Lay burgers on an oiled barbecue grill over a solid bed of hot coals or high heat on a gas grill (you can hold your hand at grill level only 2 to 3 seconds); close lid on gas grill. Cook burgers, turning once, until browned on both sides and no longer pink inside (cut to test), 7 to 8 minutes total. Remove from grill.\n" +
                        "3. Lay buns, cut side down, on grill and cook until lightly toasted, 30 seconds to 1 minute.\n" +
                        "Spread mayonnaise and etchup on bun buttoms. Add lettuce, tomato, burger, onion and salt and pepper to taste. Set bun tops in place.\n"
                ,
                "American|Lunch",
                Integer.toString(R.drawable.hamburger_meat),
                "2", "3", "2", "1", "2", "3", "2"));


        rc_burger.add(new RecipeData("Grillable Vegie Burger",
                "Vegetarian",

                "1 cup (155 g) cooked brown rice*\n"+
                        "1 cup (120 g) raw walnuts (or sub bread crumbs)\n"+
                        "1/2 Tbsp grape seed or avocado oil, plus more for cooking\n"+
                        "1/2 white onion (~55 g | 3/4 cup), finely diced\n"+
                        "1 Tbsp (~8 g) each chili powder, cumin powder, and smoked paprika\n"+
                        "1/2 tsp each sea salt and black pepper, plus more for coating burgers\n"+
                        "1 Tbsp (12 g) coconut sugar (or sub organic brown or muscovado sugar)\n"+
                        "1 1/2 cups (227 g) cooked black beans*, well rinsed, drained and patted dry\n"+
                        "1/3 cup (22 g) panko bread crumbs (if gluten free, use gluten free bread crumbs)\n"+
                        "3-4 Tbsp (51-68 g) vegan BBQ sauce\n"
                ,



                "1. If your brown rice isn’t cooked yet, start there by following this method for the best results. Otherwise, move onto the next step.\n"+
                        "2. Heat skillet over medium heat. Once hot, add raw walnuts and toast for 5-7 minutes, stirring frequently, until fragrant and golden brown. Let cool and move onto the next step.\n"+
                        "3. In the meantime, heat the same skillet over medium heat. Once hot, add 1/2 Tbsp oil and onion. Season with a bit of salt and pepper and sauté for 3-4 minutes, or until onion is fragrant, soft, and translucent. Remove from heat and set aside.\n"+
                        "4. Once walnuts are cooled, add to blender or food processor with chili powder, cumin, smoked paprika, salt, pepper and coconut sugar and blend until a fine meal (see photo) is achieved. Set aside.\n"+
                        "5. To a large mixing bowl, add drained, dried black beans and mash well with a fork, leaving only a few whole beans (see photo).\n"+
                        "6. Next add cooked rice, spice-walnut mixture, sautéed onion, panko bread crumbs, BBQ sauce, and mix thoroughly with a wooden spoon for 1-2 minutes, or until a moldable dough forms. If dry, add extra 1-2 Tbsp BBQ sauce. If too wet, add more panko bread crumbs. Taste and adjust seasonings as needed.\n"+
                        "7. For larger burgers, divide into 5 patties (1/2 cup in size), or form 10 smaller burgers (1/4 cup in size). To help form the patties, line your 1/2 or 1/4 measuring cup with plastic wrap and pack with burger mixture. Press down to pack firmly, then lift out by the plastic wrap’s edge, and slightly flatten with hands to form a 3/4-inch thick patty. Set on a baking sheet or plate for grilling.\n"+
                        "8. If grilling, heat the grill at this time and brush the grill surface with oil to ease cooking. Otherwise, heat the same skillet you used earlier to medium heat.\n"+
                        "9. Once skillet is hot, add just enough oil to lightly coat the bottom of your skillet, then add your burgers - only as as many as will comfortably fit in the pan. Otherwise, add burgers to the grill and close lid.\n"+
                        "10. Cook for 3-4 minutes or until well browned on the underside, then flip gently. They aren't as firm as meat burgers, but will definitely hold their shape. Reduce heat if cooking/browning too quickly. Cook for 3-4 minutes on other side.\n"+
                        "11. Remove burgers from heat to let cool slightly, and prepare any other toppings/sides at this time (such as grilling/toasting your buns).\n"+
                        "12. Serve burgers as is, or on toasted buns with desired toppings. Leftovers keep in the refrigerator for 2-3 days. See notes for freezing/reheating instructions.\n"
                ,
                "American|Lunch",
                Integer.toString(R.drawable.hamburger_vegetarian),
                "3", "3", "2", "1", "2", "3", "2"));


        rc_burger.add(new RecipeData("Vegan Mushroom Bean Burger Recipe",
                "Vegan",
                "1 tablespoon of canola or vegetable oil\n"+
                        "1 small onion, diced\n"+
                        "1 clove garlic, minced\n"+
                        "3 green onions, diced\n"+
                        "1/2 tsp cumin\n"+
                        "3/4 cup diced fresh mushrooms\n"+
                        "1 15-ounce can pinto beans\n"+
                        "1 tsp parsley\n"+
                        "salt and pepper, to taste (sea salt or kosher salt is always best!)\n"+
                        "oil for frying\n"
                ,

                "1. Sautee the onions and garlic in canola oil or vegetable oil for 3 to 5 minutes, until onions are soft. Add the green onions, cumin and mushrooms and cook for another 5 minutes, until mushrooms are cooked. You can add a bit more oil if needed. Set the onion and mushroom mixture aside.\n"+
                        "2. Next, use a fork or potato masher to mash the beans until well mashed. You can also pulse them in a food processor until smooth, if you prefer.\n"+
                        "3. In a large bowl, combine the mashed beans with the onion and mushroom mixture and add the parsley, salt and pepper. Make sure the ingredients are well combined.\n"+
                        "4. Shape the mixture into patties about one inch thick. If you make them too thin, they may fall apart, but if you make them too thick, it will be more difficult to get them to cook them all the way through.\n"+
                        "5. Heat about two tablespoons of oil and cook each patty until the veggie burgers are done, about 3 minutes on each side. You can also use an indoor grill pan to grill your veggie burgers, if you have one. The onion and mushroom flavor is excellent when grilled.\n"
                ,
                "American|Lunch",
                Integer.toString(R.drawable.hamburger_vegan),
                "4", "5", "5", "3", "4", "4", "5"));
        dbHandler.addRecipeComplete(rc_burger);

    }

}
