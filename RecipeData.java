package atlas.databasetest;

/**
 * Created by Silvan on 23.05.2016.
 */
public class RecipeData {
    //private variables
    int _id;
    String _type;
    String _name;
    String _ingredients;
    String _instructions;
    String _tags;
    String _image_ref;
    String _environmental_score;
    String _waterfp_score;
    String _carbonfp_score;
    String _time_score;
    String _difficulty_score;
    String _price_score;
    String _rating_score;


    // Empty constructor
    public RecipeData(){

    }
    // constructor
    public RecipeData(int id, String name, String type, String ingredients, String instructions, String tags, String image_ref, String environment_score, String waterfp_score, String carbonfp_score, String time_score, String difficulty_score, String price_score, String rating_score){
        this._id = id;
        this._name = name;
        this._type = type;
        this._ingredients = ingredients;
        this._instructions = instructions;
        this._tags = tags;
        this._image_ref = image_ref;
        this._environmental_score = environment_score;
        this._waterfp_score = waterfp_score;
        this._carbonfp_score = carbonfp_score;
        this._time_score = time_score;
        this._difficulty_score = difficulty_score;
        this._price_score = price_score;
        this._rating_score = rating_score;

        }

    // constructor
    public RecipeData(String name, String type, String ingredients, String instructions, String tags, String image_ref, String environment_score, String waterfp_score, String carbonfp_score, String time_score, String difficulty_score, String price_score, String rating_score){
        this._name = name;
        this._type = type;
        this._ingredients = ingredients;
        this._instructions = instructions;
        this._tags = tags;
        this._image_ref = image_ref;
        this._environmental_score = environment_score;
        this._waterfp_score = waterfp_score;
        this._carbonfp_score = carbonfp_score;
        this._time_score = time_score;
        this._difficulty_score = difficulty_score;
        this._price_score = price_score;
        this._rating_score = rating_score;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    // getting type
    public String getType(){
        return this._type;
    }

    public void setType(String type) {
        this._type = type;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    // getting ingredients
    public String getIngredients(){
        return this._ingredients;
    }

    public void setIngredients(String ingredients) {
        this._ingredients = ingredients;
    }

    // getting instructions
    public String getInstructions(){
        return this._instructions;
    }

    public void setInstructions(String instructions) {
        this._instructions = instructions;
    }

    // getting tags
    public String getTags(){
        return this._tags;
    }

    public void setTags(String tags) {
        this._tags = tags;
    }

    // getting image reference
    public String getImageRef(){
        return this._image_ref;
    }

    public void setImageRef(String imageRef) {
        this._image_ref = imageRef;
    }

    // getting environmental score
    public String getEnvironmentalScore(){
        return this._environmental_score;
    }

    public void setEnvironmentalScore(String environmentalScore) {
        this._environmental_score = environmentalScore;
    }

    // getting water footprint score
    public String getWaterfpScore(){
        return this._waterfp_score;
    }

    public void setWaterfpScore(String waterfpScore) {
        this._waterfp_score = waterfpScore;
    }

    // getting carbon footprint score
    public String getCarbonfpScore(){
        return this._carbonfp_score;
    }

    public void setCarbonfpScore(String carbonfpScore) {
        this._carbonfp_score = carbonfpScore;
    }

    // getting time score
    public String getTimeScore(){
        return this._time_score;
    }

    public void setTimeScore(String timeScore) {
        this._time_score = timeScore;
    }

    // getting difficulty score
    public String getDifficultyScore(){
        return this._difficulty_score;
    }

    public void setDifficultyScore(String difficultyScore) {
        this._difficulty_score = difficultyScore;
    }

    // getting price score
    public String getPriceScore(){
        return this._price_score;
    }

    public void setPriceScore(String priceScore) {
        this._price_score = priceScore;
    }

    // getting rating score
    public String getRatingScore(){
        return this._rating_score;
    }

    public void setRatingScore(String ratingScore) {
        this._rating_score = ratingScore;
    }


}
