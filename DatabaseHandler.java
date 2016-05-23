package atlas.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silvan on 23.05.2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "database";

    // Contacts table name
    private static final String TABLE_RECIPES = "recipesTable";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_INGR = "ingredients";
    private static final String KEY_INST = "instructions";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_IMAG = "imageRef";
    private static final String KEY_ENVI = "environment";
    private static final String KEY_WATE = "waterfp";
    private static final String KEY_CARB = "carbonfp";
    private static final String KEY_TIME = "time";
    private static final String KEY_DIFF = "difficulty";
    private static final String KEY_PRIC = "price";
    private static final String KEY_RATI = "rating";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table, if it already existed it'll "open" it
        //TODO: check whether "INT" works
        String CREATE_RECIPES_TABLE = "CREATE TABLE " + TABLE_RECIPES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_INGR + " TEXT,"
                + KEY_INST + " TEXT,"
                + KEY_TAGS + " TEXT,"
                + KEY_IMAG + " TEXT,"
                + KEY_ENVI + " INT,"
                + KEY_WATE + " INT,"
                + KEY_CARB + " INT,"
                + KEY_TIME + " INT,"
                + KEY_DIFF + " INT,"
                + KEY_PRIC + " INT,"
                + KEY_RATI + " INT"  + ")";
        db.execSQL(CREATE_RECIPES_TABLE);



    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);

        // Create tables again
        onCreate(db);
    }

    // Adding new recipe
    public void addRecipe(RecipeData recipe) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_TYPE, recipe.getType());
        values.put(KEY_INGR, recipe.getIngredients());
        values.put(KEY_INST, recipe.getInstructions());
        values.put(KEY_TAGS, recipe.getTags());
        values.put(KEY_IMAG, recipe.getImageRef());
        values.put(KEY_ENVI, recipe.getEnvironmentalScore());
        values.put(KEY_WATE, recipe.getWaterfpScore());
        values.put(KEY_CARB, recipe.getCarbonfpScore());
        values.put(KEY_TIME, recipe.getTimeScore());
        values.put(KEY_DIFF, recipe.getDifficultyScore());
        values.put(KEY_PRIC, recipe.getPriceScore());
        values.put(KEY_RATI, recipe.getRatingScore());

        // Inserting Row
        db.insert(TABLE_RECIPES, null, values);
        db.close(); // Closing database connection
    }


    //Adding a recipe for each extent
    public void addRecipeComplete(List<RecipeData> recipes){
        if(recipes.size()!=4){
            Log.w("DATABASE", "Failed to add recipes because list doesn't have the right size");
        }
        else{
            for (RecipeData r : recipes){
                addRecipe(r);
            }
        }
    }


    // Getting single recipe
    public RecipeData getRecipe(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RECIPES, new String[] { KEY_ID,
                        KEY_NAME, KEY_TYPE, KEY_INGR, KEY_INST, KEY_TAGS, KEY_IMAG, KEY_ENVI, KEY_WATE, KEY_CARB, KEY_TIME, KEY_DIFF, KEY_PRIC, KEY_RATI }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        //TODO: not sure whether the int part works (cursor.getInt(0) instead of Integer.parseInt(cursor.getString(0)), where is id?)
        RecipeData recipe = new RecipeData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10), cursor.getInt(11), cursor.getInt(12), cursor.getInt(13));
        // return contact
        return recipe;
    }

    // Getting All recipes
    public List<RecipeData> getAllRecipes() {
        List<RecipeData> contactList = new ArrayList<RecipeData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RECIPES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        //TODO: still not sure whether the int thing works or whether I have to do a parse thing
        if (cursor.moveToFirst()) {
            do {
                RecipeData recipe = new RecipeData();
                recipe.setID(Integer.parseInt(cursor.getString(0)));
                recipe.setName(cursor.getString(1));
                recipe.setType(cursor.getString(2));
                recipe.setIngredients(cursor.getString(3));
                recipe.setInstructions(cursor.getString(4));
                recipe.setTags(cursor.getString(5));
                recipe.setImageRef(cursor.getString(6));
                recipe.setEnvironmentalScore(cursor.getInt(7));
                recipe.setWaterfpScore(cursor.getInt(8));
                recipe.setCarbonfpScore(cursor.getInt(9));
                recipe.setTimeScore(cursor.getInt(10));
                recipe.setDifficultyScore(cursor.getInt(11));
                recipe.setPriceScore(cursor.getInt(12));
                recipe.setRatingScore(cursor.getInt(13));
                // Adding recipe to list
                contactList.add(recipe);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    // Getting recipes Count
    public int getRecipesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_RECIPES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


    // Updating single recipe
    public int updateRecipe(RecipeData recipe) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, recipe.getName());
        values.put(KEY_TYPE, recipe.getType());
        values.put(KEY_INGR, recipe.getIngredients());
        values.put(KEY_INST, recipe.getInstructions());
        values.put(KEY_TAGS, recipe.getTags());
        values.put(KEY_IMAG, recipe.getImageRef());
        values.put(KEY_ENVI, recipe.getEnvironmentalScore());
        values.put(KEY_WATE, recipe.getWaterfpScore());
        values.put(KEY_CARB, recipe.getCarbonfpScore());
        values.put(KEY_TIME, recipe.getTimeScore());
        values.put(KEY_DIFF, recipe.getDifficultyScore());
        values.put(KEY_PRIC, recipe.getPriceScore());
        values.put(KEY_RATI, recipe.getRatingScore());

        // updating row
        return db.update(TABLE_RECIPES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(recipe.getID()) });
    }

    // Deleting single recipe
    public void deleteRecipe(RecipeData recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RECIPES, KEY_ID + " = ?",
                new String[] { String.valueOf(recipe.getID()) });
        db.close();
    }
    //DONT KNOW WHETHER THIS WORKS
    public void deleteRecipe(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RECIPES, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

}
