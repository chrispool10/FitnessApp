package com.example.mealplan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.util.Calendar;

public class MyDay extends Fragment implements OnItemClickListener {


Cursor schedule1, schedule2, schedule3, schedule4;

    View view;

    public static MyDay newInstance() {
        MyDay fragment = new MyDay();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MyDay() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity1, container, false);

        MyDatabase db = new MyDatabase(getActivity());
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);


        if(day == 1){
            schedule1 = db.getWorkout_day1();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_1", "wType_1", "Equipment_1"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day1();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day1();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day1();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else if (day == 2)
        {
            schedule1 = db.getWorkout_day2();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_4", "wType_4", "Equipment_4"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day2();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day2();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day2();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else if (day == 3){
            schedule1 = db.getWorkout_day3();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_3", "wType_3", "Equipment_3"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day3();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day3();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day3();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else if (day == 4){
            schedule1 = db.getWorkout_day4();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_4", "wType_4", "Equipment_4"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day4();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day4();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day4();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else if (day == 5){
            schedule1 = db.getWorkout_day5();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_5", "wType_5", "Equipment_5"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day5();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day5();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day5();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else if (day == 6){
            schedule1 = db.getWorkout_day6();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_6", "wType_6", "Equipment_6"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day6();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day6();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day6();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }
        else{
            schedule1 = db.getWorkout_day7();
            ListView listView1 = (ListView) view.findViewById(R.id.list);
            listView1.setOnItemClickListener(this);
            listView1.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule1,
                    new String[]{"wName_7", "wType_7", "Equipment_7"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView1);
            schedule2 = db.getMeal_1_day7();
            ListView listView2 = (ListView) view.findViewById(R.id.listMeal1);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);
            schedule3 = db.getMeal_2_day7();
            ListView listView3 = (ListView) view.findViewById(R.id.listMeal2);
            listView3.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView3);
            schedule4 = db.getMeal_3_day7();
            ListView listView4 = (ListView) view.findViewById(R.id.listMeal3);
            listView4.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row,
                    schedule2,
                    new String[]{"fName", "Calories", "Protein", "Carbs"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView4);
        }



        return view;
       }


    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), Description.class);
        intent.putExtra("Carbs", ((TextView) v.findViewById(R.id.textView4)).getText()) ;
        startActivity(intent);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}


