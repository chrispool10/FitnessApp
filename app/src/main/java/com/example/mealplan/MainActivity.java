package com.example.mealplan;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.View;
import android.view.*;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class MainActivity extends FragmentActivity implements CreateProfile.Callbacks, OnItemClickListener,
        PreWorkoutPlan.Callbacks, PreMealPlan.Callbacks, Settings.Callbacks, SettingsAllWork.Callbacks,
        SettingsMyWorkout.Callbacks, SettingsMyMeal.Callbacks, SettingsAllMeal.Callbacks, SettingsCreate.Callbacks {


    private Callbacks mCallbacks = sDummyCallbacks;

    ViewPager viewPager;
    CreateProfile createFrag;
    MyDay mydayFrag;
    MyWeek myweekFrag;
    MyMealPlan mymealFrag;
    Settings settingsFrag;

    SettingsCreate create_settings;// = new SettingsCreate();
    SettingsAllWork allwork_settings;// = new SettingsAllWork();
    SettingsMyWorkout workout_settings;// = new SettingsMyWorkout();
    SettingsAllMeal allmeal_settings;// = new SettingsAllMeal();
    SettingsMyMeal meal_settings;// = new SettingsMyMeal();

    private Cursor schedule1, schedule2;
    private MyDatabase db;
    ListView listView, listView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyDatabase(this);


        FragmentManager fragmentManager = getSupportFragmentManager();
        int x=1;

        if ((db.isFull("Users"))==1) {
            setContentView(R.layout.view_pager);
            mydayFrag = new MyDay();
            myweekFrag = new MyWeek();
            mymealFrag = new MyMealPlan();
            settingsFrag = new Settings();
            fragmentManager = getSupportFragmentManager();
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new FragPagerAdapter(fragmentManager));
        } else {
            fragmentManager.beginTransaction().add(R.id.container, new CreateProfile()).commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, Description.class);
        intent.putExtra("Carbs", ((TextView) v.findViewById(R.id.textView4)).getText()) ;
        startActivity(intent);
    }

    public class FragPagerAdapter extends FragmentStatePagerAdapter {
        int pagecount = 4;

        public FragPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: return mydayFrag;
                case 1: return myweekFrag;
                case 2: return mymealFrag;
                case 3: return settingsFrag;
                default: return null;
            }
        }

        @Override
        public int getCount() {

            return pagecount;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "My Day";
                case 1:
                    return "My Workout Plan";
                case 2:
                    return "My Meal Plan";
                case 3:
                    return "Settings";
            }
            return null;

        }

    }


    public void ValidProfile(String usr, int calintake, int workpw)
    {
        if ((db.isFull("Users"))==1) {
            String cal = Integer.toString(calintake);
            String work = Integer.toString(workpw);
            db.TransferProfile(usr, cal, work);
            db.getUser();
            setContentView(R.layout.view_pager);
            mydayFrag = new MyDay();
            myweekFrag = new MyWeek();
            mymealFrag = new MyMealPlan();
            settingsFrag = new Settings();
            FragmentManager fragmentManager = getSupportFragmentManager();
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new FragPagerAdapter(fragmentManager));
        }
        else {
            String cal = Integer.toString(calintake);
            String work = Integer.toString(workpw);
            db.TransferProfile(usr, cal, work);
            db.getUser();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreWorkoutPlan()).commit();
        }

    }

    @Override
    public void nextWindow1(int x) {
        if (x == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new PreMealPlan()).commit();
        }
        else
        {
            setContentView(R.layout.view_pager);
            mydayFrag = new MyDay();
            myweekFrag = new MyWeek();
            mymealFrag = new MyMealPlan();
            settingsFrag = new Settings();
            FragmentManager fragmentManager = getSupportFragmentManager();
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(new FragPagerAdapter(fragmentManager));
        }
    }

    @Override
    public void doneModify()
    {
        setContentView(R.layout.view_pager);
        mydayFrag = new MyDay();
        myweekFrag = new MyWeek();
        mymealFrag = new MyMealPlan();
        settingsFrag = new Settings();
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new FragPagerAdapter(fragmentManager));
    }

    @Override
     public void settingsCreate()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.createFrag, new SettingsCreate()).commit();
    }

    @Override
    public void settingsModifyWork()
    {
        setContentView(R.layout.view_pager2);
        workout_settings = new SettingsMyWorkout();
        allwork_settings = new SettingsAllWork();
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pager2);
        viewPager.setAdapter(new WorkSetFragPagerAdapter(fragmentManager));
    }

    @Override
    public void settingsModifyMeal()
    {
        setContentView(R.layout.view_pager3);
        meal_settings = new SettingsMyMeal();
        allmeal_settings = new SettingsAllMeal();
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.pager3);
        viewPager.setAdapter(new MealSetFragPagerAdapter(fragmentManager));
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {

        public void TransferProfile(String usr, String calintake, String workpw) {
        }
    };

    public interface Callbacks {
        public void TransferProfile(String usr, String calintake, String workpw);
    }

    public class WorkSetFragPagerAdapter extends FragmentStatePagerAdapter {
        int pagecount = 2;

        public WorkSetFragPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: return workout_settings;
                case 1: return allwork_settings;
                default: return null;
            }
        }

        @Override
        public int getCount() {

            return pagecount;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "My Workout";
                case 1:
                    return "All Workouts";
            }
            return null;

        }

    }

    public class MealSetFragPagerAdapter extends FragmentStatePagerAdapter {
        int pagecount = 2;

        public MealSetFragPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: return meal_settings;
                case 1: return allmeal_settings;
                default: return null;
            }
        }

        @Override
        public int getCount() {

            return pagecount;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "My Meal Plan";
                case 1:
                    return "All Food Items";
            }
            return null;

        }

    }

}
