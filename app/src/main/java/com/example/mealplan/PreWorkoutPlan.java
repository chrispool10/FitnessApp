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


/**
 * Created by cpool on 3/1/2015.
 */
public class PreWorkoutPlan extends Fragment implements AdapterView.OnItemClickListener {

    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;

    public static PreWorkoutPlan newInstance() {
        PreWorkoutPlan fragment = new PreWorkoutPlan();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PreWorkoutPlan() {
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
        View view = inflater.inflate(R.layout.preworkout_plan, container, false);

        Button next = (Button) view.findViewById(R.id.done1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.nextWindow1(0);
            }
        });

        MyDatabase db = new MyDatabase(getActivity());

        Cursor schedule1 = db.getWorkout_day1();
        ListView listView1 = (ListView) view.findViewById(R.id.list1);
        listView1.setOnItemClickListener(this);
        listView1.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule1,
                new String[]{"wName_1", "wType_1", "Equipment_1"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView1);

            Cursor schedule2 = db.getWorkout_day2();
            ListView listView2 = (ListView) view.findViewById(R.id.list2);
            listView2.setOnItemClickListener(this);
            listView2.setAdapter(new SimpleCursorAdapter(
                    getActivity(),
                    R.layout.row2,
                    schedule2,
                    new String[]{"wName_2", "wType_2", "Equipment_2"},
                    new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                    0));
            Utility.setListViewHeightBasedOnChildren(listView2);

        Cursor schedule3 = db.getWorkout_day3();
        ListView listView3 = (ListView) view.findViewById(R.id.list3);
        listView3.setOnItemClickListener(this);
        listView3.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule3,
                new String[]{"wName_3", "wType_3", "Equipment_3"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView3);

        Cursor schedule4 = db.getWorkout_day4();
        ListView listView4 = (ListView) view.findViewById(R.id.list4);
        listView4.setOnItemClickListener(this);
        listView4.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule4,
                new String[]{"wName_4", "wType_4", "Equipment_4"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView4);

        Cursor schedule5 = db.getWorkout_day5();
        ListView listView5 = (ListView) view.findViewById(R.id.list5);
        listView5.setOnItemClickListener(this);
        listView5.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule5,
                new String[]{"wName_5", "wType_5", "Equipment_5"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView5);

        Cursor schedule6 = db.getWorkout_day6();
        ListView listView6 = (ListView) view.findViewById(R.id.list6);
        listView6.setOnItemClickListener(this);
        listView6.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule6,
                new String[]{"wName_6", "wType_6", "Equipment_6"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView6);

        Cursor schedule7 = db.getWorkout_day7();
        ListView listView7 = (ListView) view.findViewById(R.id.list7);
        listView7.setOnItemClickListener(this);
        listView7.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row2,
                schedule7,
                new String[]{"wName_7", "wType_7", "Equipment_7"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3},
                0));
        Utility.setListViewHeightBasedOnChildren(listView7);

        return view;
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
        OnFragmentInteractionListener mListener = null;
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {

        public void nextWindow1(int x) {
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public interface Callbacks {
        public void nextWindow1(int x);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
