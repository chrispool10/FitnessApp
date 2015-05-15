package com.example.mealplan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;

public class SettingsAllMeal extends Fragment implements OnItemClickListener {
    //    String user;
//    int age;
//    int weight;
//    int workoutperweek;
//    int goalweight;
//    int budget;
//    int calorieintake;
    Cursor schedule1, schedule2, schedule3, schedule4;
    MyDatabase db;
    int day;

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;
    Context mContext;

    String mTables;

    String[] mealOfDay = {"fst", "snd", "trd"};
    ArrayList<String> chosenMeal = new ArrayList<String>();

    //boolean

    public static SettingsAllMeal newInstance() {
        SettingsAllMeal fragment = new SettingsAllMeal();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsAllMeal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    //Eli's contribution to the project <-

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_frag, container, false);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

        mContext = getActivity();
        db = new MyDatabase(mContext);

        if(day == 1)
        {
            mTables = "Meal_1";
        }
        else if (day == 2)
        {
            mTables = "Meal_2";
        }
        else if (day == 3)
        {
            mTables = "Meal_3";
        }
        else if (day == 4)
        {
            mTables = "Meal_4";
        }
        else if (day == 5)
        {
            mTables = "Meal_5";
        }
        else if (day == 6)
        {
            mTables = "Meal_6";
        }
        else if (day == 7)
        {
            mTables = "Meal_7";
        }

        schedule1 = db.getSchedule();
        ListView listView1 = (ListView) view.findViewById(R.id.listView110);
        listView1.setOnItemClickListener(this);
        listView1.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule1,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView1);

        Button done = (Button) view.findViewById(R.id.settings_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.doneModify();
            }
        });

        return view;
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {

        final boolean[] checkedItems = new boolean [] {false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.meal_prompt)
                .setMultiChoiceItems(R.array.meal_array, checkedItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                checkedItems[which] = isChecked;
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        for (int i = 0; i < 8; i++) {
                            if (checkedItems[i]) {
                                chosenMeal.add(mealOfDay[i]);
                            }
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        builder.create().show();
        for (String meal : chosenMeal) {
            db.insertFood(meal + mTables, position);
        }
        chosenMeal.clear();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myContext = activity.getApplicationContext();
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = sDummyCallbacks;
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {

        public void ValidProfile() {
        }
        //Log.v("callback", "onitemselected dummny");
        public void doneModify(){
        }
    };

    public interface Callbacks {
        public void doneModify();
    }

}