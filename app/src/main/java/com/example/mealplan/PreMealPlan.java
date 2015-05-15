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
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Calendar;

/**
 * Created by cpool on 3/1/2015.
 */
public class PreMealPlan extends Fragment {

    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;

    public static PreMealPlan newInstance() {
        PreMealPlan fragment = new PreMealPlan();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PreMealPlan() {
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
        View view = inflater.inflate(R.layout.premeal_plan, container, false);

        Button next = (Button) view.findViewById(R.id.done2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.nextWindow1(1);
            }
        });

        MyDatabase db = new MyDatabase(getActivity());
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        Cursor schedule1 = db.getMeal_1_day1();
        ListView listView1 = (ListView) view.findViewById(R.id.list1);
        listView1.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule1,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView1);

        Cursor schedule2 = db.getMeal_2_day1();
        ListView listView2 = (ListView) view.findViewById(R.id.list2);
        listView2.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule2,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView2);

        Cursor schedule3 = db.getMeal_3_day1();
        ListView listView3 = (ListView) view.findViewById(R.id.list3);
        listView3.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule3,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView3);

        Cursor schedule4 = db.getMeal_1_day2();
        ListView listView4 = (ListView) view.findViewById(R.id.list4);
        listView4.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule4,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView4);

        Cursor schedule5 = db.getMeal_2_day2();
        ListView listView5 = (ListView) view.findViewById(R.id.list5);
        listView5.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule5,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView5);

        Cursor schedule6 = db.getMeal_3_day2();
        ListView listView6 = (ListView) view.findViewById(R.id.list6);
        listView6.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule6,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView6);

        Cursor schedule7 = db.getMeal_1_day3();
        ListView listView7 = (ListView) view.findViewById(R.id.list7);
        listView7.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule7,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView7);

        Cursor schedule8 = db.getMeal_2_day3();
        ListView listView8 = (ListView) view.findViewById(R.id.list8);
        listView8.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule8,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView8);

        Cursor schedule9 = db.getMeal_3_day3();
        ListView listView9 = (ListView) view.findViewById(R.id.list9);
        listView9.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule9,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView9);

        Cursor schedule10 = db.getMeal_1_day4();
        ListView listView10 = (ListView) view.findViewById(R.id.list10);
        listView10.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule10,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView10);

        Cursor schedule11 = db.getMeal_2_day4();
        ListView listView11 = (ListView) view.findViewById(R.id.list11);
        listView11.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule11,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView11);

        Cursor schedule12 = db.getMeal_3_day4();
        ListView listView12 = (ListView) view.findViewById(R.id.list12);
        listView12.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule12,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView12);

        Cursor schedule13 = db.getMeal_1_day5();
        ListView listView13 = (ListView) view.findViewById(R.id.list13);
        listView13.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule13,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView13);

        Cursor schedule14 = db.getMeal_2_day5();
        ListView listView14 = (ListView) view.findViewById(R.id.list14);
        listView14.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule14,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView14);

        Cursor schedule15 = db.getMeal_3_day5();
        ListView listView15 = (ListView) view.findViewById(R.id.list15);
        listView15.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule15,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView15);

        Cursor schedule16 = db.getMeal_1_day6();
        ListView listView16 = (ListView) view.findViewById(R.id.list16);
        listView16.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule16,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView16);

        Cursor schedule17 = db.getMeal_2_day6();
        ListView listView17 = (ListView) view.findViewById(R.id.list17);
        listView17.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule17,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView17);

        Cursor schedule18 = db.getMeal_3_day6();
        ListView listView18 = (ListView) view.findViewById(R.id.list18);
        listView18.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule18,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView18);

        Cursor schedule19 = db.getMeal_1_day7();
        ListView listView19 = (ListView) view.findViewById(R.id.list19);
        listView19.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule19,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView19);

        Cursor schedule20 = db.getMeal_2_day7();
        ListView listView20 = (ListView) view.findViewById(R.id.list20);
        listView20.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule20,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView20);

        Cursor schedule21 = db.getMeal_3_day7();
        ListView listView21 = (ListView) view.findViewById(R.id.list21);
        listView21.setAdapter(new SimpleCursorAdapter(
                getActivity(),
                R.layout.row,
                schedule21,
                new String[]{"fName", "Calories", "Protein", "Carbs"},
                new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4},
                0));
        Utility.setListViewHeightBasedOnChildren(listView21);
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

    public interface Callbacks {
        public void nextWindow1(int x);
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}