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

public class SettingsMyMeal extends Fragment implements OnItemClickListener {

    Cursor schedule1, schedule2, schedule3;
    MyDatabase db;
    int day;

    private Context myContext;

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;

    String mTables;

    public static SettingsMyMeal newInstance() {
        SettingsMyMeal fragment = new SettingsMyMeal();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsMyMeal() {
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
        View view = inflater.inflate(R.layout.settings_mymealplan, container, false);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);

        myContext = getActivity();
        db = new MyDatabase(myContext);

        if(day == 1){
            schedule1 = db.getMeal_1_day1();
            mTables = "fstMeal_1";
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

            schedule2 = db.getMeal_2_day1();
            mTables = "sndMeal_1";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day1();
            mTables = "trdMeal_1";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else if (day == 2)
        {
            schedule1 = db.getMeal_1_day2();
            mTables = "fstMeal_2";
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

            schedule2 = db.getMeal_2_day2();
            mTables = "sndMeal_2";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day2();
            mTables = "trdMeal_2";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else if (day == 3){
            schedule1 = db.getMeal_1_day3();
            mTables = "fstMeal_3";
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

            schedule2 = db.getMeal_2_day3();
            mTables = "sndMeal_3";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day3();
            mTables = "trdMeal_3";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else if (day == 4){
            schedule1 = db.getMeal_1_day4();
            mTables = "fstMeal_4";
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

            schedule2 = db.getMeal_2_day4();
            mTables = "sndMeal_4";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day4();
            mTables = "trdMeal_4";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else if (day == 5){
            schedule1 = db.getMeal_1_day5();
            mTables = "fstMeal_5";
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

            schedule2 = db.getMeal_2_day5();
            mTables = "sndMeal_5";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day5();
            mTables = "trdMeal_5";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else if (day == 6){
            schedule1 = db.getMeal_1_day6();
            mTables = "fstMeal_6";
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

            schedule2 = db.getMeal_2_day6();
            mTables = "sndMeal_6";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day6();
            mTables = "trdMeal_6";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }
        else{
            schedule1 = db.getMeal_1_day7();
            mTables = "fstMeal_7";
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

            schedule2 = db.getMeal_2_day7();
            mTables = "sndMeal_7";
            ListView listView2 = (ListView) view.findViewById(R.id.listView111);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

            schedule3 = db.getMeal_3_day7();
            mTables = "trdMeal_7";
            ListView listView3 = (ListView) view.findViewById(R.id.listView112);
            listView3.setOnItemClickListener(this);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule3,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
        }

//        Button done = (Button) view.findViewById(R.id.settings_done);
//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCallbacks.doneModify();
//            }
//        });

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