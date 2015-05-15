package com.example.mealplan;

import android.app.Activity;
import android.content.Context;
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

import java.util.Calendar;

public class SettingsMyWorkout extends Fragment implements ListView.OnItemClickListener {
//    String user;
//    int age;
//    int weight;
//    int workoutperweek;
//    int goalweight;
//    int budget;
//    int calorieintake;
Cursor schedule1, schedule2, schedule3, schedule4;
    MyDatabase db;// = new MyDatabase(getActivity());
    int day;
    private Context myContext;

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;

    String mTables;

    //boolean

    public static SettingsMyWorkout newInstance() {
        SettingsMyWorkout fragment = new SettingsMyWorkout();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsMyWorkout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //db.getReadableDatabase();
    }
    //Eli's contribution to the project <-

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_myworkout, container, false);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

        myContext = getActivity();
        db = new MyDatabase(myContext);

        if(day == 1){
            schedule1 = db.getWorkout_day1();
            mTables = "WorkoutDay_1";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_1", "wType_1", "Equipment_1"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
        }
        else if (day == 2)
        {
            schedule1 = db.getWorkout_day2();
            mTables = "WorkoutDay_2";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_2", "wType_2", "Equipment_2"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }
        else if (day == 3){
            schedule1 = db.getWorkout_day3();
            mTables = "WorkoutDay_3";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_3", "wType_3", "Equipment_3"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }
        else if (day == 4){
            schedule1 = db.getWorkout_day4();
            mTables = "WorkoutDay_4";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_4", "wType_4", "Equipment_4"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }
        else if (day == 5){
            schedule1 = db.getWorkout_day5();
            mTables = "WorkoutDay_5";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_5", "wType_5", "Equipment_5"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }
        else if (day == 6){
            schedule1 = db.getWorkout_day6();
            mTables = "WorkoutDay_6";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setClickable(true);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_6", "wType_6", "Equipment_6"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }
        else{
            schedule1 = db.getWorkout_day7();
            mTables = "WorkoutDay_7";
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_7", "wType_7", "Equipment_7"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            }

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
       db.deleteRecord(mTables, position);
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