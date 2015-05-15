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

public class SettingsAllWork extends Fragment implements OnItemClickListener {
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

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;
    private Context mContext;

    String mTables;

    //boolean

    public static SettingsAllWork newInstance() {
        SettingsAllWork fragment = new SettingsAllWork();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsAllWork() {
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
        final View view = inflater.inflate(R.layout.settings_myworkout, container, false);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

        mContext = getActivity();
        MyDatabase db = new MyDatabase(mContext);

        if(day == 1)
        {
            mTables = "WorkoutDay_1";
        }
        else if (day == 2)
        {
            mTables = "WorkoutDay_2";
        }
        else if (day == 3)
        {
            mTables = "WorkoutDay_3";
        }
        else if (day == 4)
        {
            mTables = "WorkoutDay_4";
        }
        else if (day == 5)
        {
            mTables = "WorkoutDay_5";
        }
        else if (day == 6)
        {
            mTables = "WorkoutDay_6";
        }
        else if (day == 7)
        {
            mTables = "WorkoutDay_7";
        }

            schedule1 = db.getAllWorkout();
            ListView listView1 = (ListView) view.findViewById(R.id.wSettingView);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName", "wType", "Equipment"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
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
        db.insertRecord(mTables, day, position);
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