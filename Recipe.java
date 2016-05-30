package atlas.apple;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.database.sqlite.*;

import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import atlas.apple.R;

public class Recipe extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    //The recipeTable is where the data is
    DatabaseHandler recipeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recipeTable = ((MyApplication)getApplication()).recipeTable;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     * The fragment contains the content of the recipe tab
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public PlaceholderFragment() {
        }

        private static final String ARG_RECIPE_NAME = "recipename";
        private static final String ARG_EXTENT = "extent";
        private static final String ARG_INGREDIENTS = "ingredients";
        private static final String ARG_INSTRUCTIONS = "instructions";
        private static final String ARG_TAGS = "tags";
        private static final String ARG_IMAGE_REF = "imageref";
        private static final String ARG_ENVIRONMENTAL_SCORE = "enviscore";
        private static final String ARG_WATERFP_SCORE = "watescore";
        private static final String ARG_CARBONFP_SCORE = "carbscore";
        private static final String ARG_TIME_SCORE = "timescore";
        private static final String ARG_DIFFICULTY_SCORE = "diffscore";
        private static final String ARG_PRICE_SCORE = "pricscore";
        private static final String ARG_RATING_SCORE = "ratiscore";


        ImageButton environmentBtn;
        ImageButton waterBtn;
        ImageButton carbonBtn;
        ImageButton timeBtn;
        ImageButton difficultyBtn;
        ImageButton priceBtn;
        ImageButton rankingBtn;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String recipeName, String extent, String ingredients, String instructions, String tags, String imageRef, String enviScore, String wateScore, String carbScore, String timeScore, String diffScore, String pricScore, String ratiScore) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            //THE ARGUMENTS THAT YOU GIVE WITH CREATING THE FRAGMENT,
            //TODO: extend with the other arguments
            args.putString(ARG_RECIPE_NAME, recipeName);
            args.putString(ARG_EXTENT, extent);
            args.putString(ARG_INGREDIENTS, ingredients);
            args.putString(ARG_INSTRUCTIONS, instructions);
            args.putString(ARG_TAGS, tags);
            args.putString(ARG_IMAGE_REF, imageRef);
            args.putString(ARG_ENVIRONMENTAL_SCORE, enviScore);
            args.putString(ARG_WATERFP_SCORE, wateScore);
            args.putString(ARG_CARBONFP_SCORE, carbScore);
            args.putString(ARG_TIME_SCORE, timeScore);
            args.putString(ARG_DIFFICULTY_SCORE, diffScore);
            args.putString(ARG_PRICE_SCORE, pricScore);
            args.putString(ARG_RATING_SCORE, ratiScore);

            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);

            //Change the widgets in the tab
            TextView vw_name = (TextView) rootView.findViewById(R.id.titleRecipe);
            vw_name.setText(getArguments().getString(ARG_EXTENT)+" "+getArguments().getString(ARG_RECIPE_NAME));

            //Still missing
            //TextView vw_extent = (TextView) rootView.findViewById(R.id.extent);
            //vw_extent.setText(getArguments().getString(ARG_EXTENT));

            TextView vw_ingredients = (TextView) rootView.findViewById(R.id.ingredients);
            vw_ingredients.setText(getArguments().getString(ARG_INGREDIENTS));

            TextView vw_instructions = (TextView) rootView.findViewById(R.id.instructions);
            vw_instructions.setText(getArguments().getString(ARG_INSTRUCTIONS));


            //POP-UP'S FOR INFORMATION IN THE INFORMATION SECTION
            //TODO: add buttons/images dependent on score

            environmentBtn = (ImageButton) rootView.findViewById(R.id.environmentBtn);
            environmentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupEnvironment.class));
                }
            });

            waterBtn = (ImageButton) rootView.findViewById(R.id.waterBtn);
            waterBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupWater.class));
                }
            });

            carbonBtn = (ImageButton) rootView.findViewById(R.id.carbonBtn);
            carbonBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupCarbon.class));
                }
            });

            timeBtn = (ImageButton) rootView.findViewById(R.id.timeBtn);
            timeBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupTime.class));
                }
            });

            difficultyBtn = (ImageButton) rootView.findViewById(R.id.difficultyBtn);
            difficultyBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupDifficulty.class));
                }
            });

            priceBtn = (ImageButton) rootView.findViewById(R.id.priceBtn);
            priceBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupPrice.class));
                }
            });

            rankingBtn = (ImageButton) rootView.findViewById(R.id.ratingBtn);
            rankingBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    startActivity(new Intent(getContext(), PopupRanking.class));
                }
            });


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            //The content of the recipe tab is loaded here
            RecipeData recipe = recipeTable.getRecipe(position+1);
            return PlaceholderFragment.newInstance(position, recipe.getName(), recipe.getType(), recipe.getIngredients(), recipe.getInstructions(), recipe.getTags(), recipe.getImageRef(), recipe.getEnvironmentalScore(), recipe.getWaterfpScore(), recipe.getCarbonfpScore(), recipe.getTimeScore(), recipe.getDifficultyScore(), recipe.getPriceScore(), recipe.getRatingScore());
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
            }
            return null;
        }
    }
}
