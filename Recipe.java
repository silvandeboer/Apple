package atlas.apple;

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

        private static final String ARG_RECIPE_NAME = "recipename";
        private static final String ARG_EXTENT = "extent";
        private static final String ARG_INGREDIENTS = "ingredients";


        //public PlaceholderFragment() {
        //}

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String recipeName, String extent, String ingredients) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            //THE ARGUMENTS THAT YOU GIVE WITH CREATING THE FRAGMENT,
            //TODO: extend with the other arguments
            args.putString(ARG_RECIPE_NAME, recipeName);
            args.putString(ARG_EXTENT, extent);
            args.putString(ARG_INGREDIENTS, ingredients);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);

            //Change the widgets in the tab
            TextView vw_name = (TextView) rootView.findViewById(R.id.recipe_name);
            vw_name.setText(getArguments().getString(ARG_RECIPE_NAME));

            TextView vw_extent = (TextView) rootView.findViewById(R.id.extent);
            vw_extent.setText(getArguments().getString(ARG_EXTENT));

            TextView vw_ingredients = (TextView) rootView.findViewById(R.id.ingredients);
            vw_ingredients.setText(getArguments().getString(ARG_INGREDIENTS));

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
            return PlaceholderFragment.newInstance(position, recipe.getName(), recipe.getType(), recipe.getIngredients());
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
