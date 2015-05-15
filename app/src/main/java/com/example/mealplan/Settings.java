package com.example.mealplan;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Settings extends Fragment {
    String user;
    int age;
    int weight;
    int workoutperweek;
    int goalweight;
    int budget;
    int calorieintake;

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;
    private MyDatabase db;

    public static Settings newInstance() {
        Settings fragment = new Settings();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Settings() {
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
        View view = inflater.inflate(R.layout.settings, container, false);

        Button modWork = (Button) view.findViewById(R.id.wpbutton);
        modWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.settingsModifyWork();
            }
        });

        Button modMeal = (Button) view.findViewById(R.id.mpbutton);
        modMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.settingsModifyMeal();
            }
        });

        Button modProfile = (Button) view.findViewById(R.id.epbutton);
        modProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.settingsCreate();
            }
        });

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
        mListener = null;
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        public void settingsCreate(){

        }
        public void settingsModifyWork(){

        }
        public void settingsModifyMeal(){

        }
    };

    public interface Callbacks {
        public void settingsCreate();
        public void settingsModifyWork();
        public void settingsModifyMeal();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}