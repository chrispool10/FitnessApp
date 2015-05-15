package com.example.mealplan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cpool on 4/14/2015.
 */
public class SettingsCreate extends Fragment{

    private OnFragmentInteractionListener mListener;
    private Callbacks mCallbacks = sDummyCallbacks;
    Context myContext;
    private MyDatabase db;

    EditText textusername;
    EditText textage;
    EditText textweight;
    EditText textgoal;
    //EditText textbudget;
    EditText textcalorieintake;
    //11EditText textallergies;

    Button next;

    String[] allAllergies = {"Milk", "Eggs", "Fish", "Shellfish", "Treenuts", "Peanuts", "Wheat", "Soy"};
    ArrayList<String> myAllergies = new ArrayList<String>();

    Spinner spinner;
    //Spinner allergySpinner;

    String user;
    int age;
    int weight;
    int workoutperweek;
    int goalweight;
    //int budget;
    int calorieintake;
    //String allergies;




    public static SettingsCreate newInstance() {
        SettingsCreate fragment = new SettingsCreate();
        Bundle args = new Bundle();
        return fragment;
    }

    public SettingsCreate() {
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
        final View view = inflater.inflate(R.layout.create_profile, container, false);



        addSpinnerListener(view);
        Button next = (Button) view.findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProfile(view);
            }
        });

        Button allergy = (Button) view.findViewById(R.id.allergybutton);
        allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAllergies(view);
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

        public void ValidProfile() {
        }
        //Log.v("callback", "onitemselected dummny");
        public void ValidProfile(String usr, int calintake, int workpw){
        }
        //@Override
        //public void invalidateView() {
        //}
    };

    public interface Callbacks {
        public void ValidProfile(String user, int calintake, int workpw);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void createProfile(View v)
    {

        boolean validpro = true;

        textusername = (EditText) v.findViewById(R.id.username);
        textage = (EditText) v.findViewById(R.id.age);
        textweight = (EditText) v.findViewById(R.id.weight);
        textgoal = (EditText) v.findViewById(R.id.goalweight);
        //textbudget = (EditText) v.findViewById(R.id.budget);
        textcalorieintake = (EditText) v.findViewById(R.id.calorieintake);
        //textallergies = (EditText) v.findViewById(R.id.allergies);

        String temp = textusername.getText().toString();

        if(temp.length() > 25)
        {
            Toast.makeText(myContext, "Username must be less than 26 characters", Toast.LENGTH_LONG);
            validpro = false;
        }
        else
            user = temp;

        age = Integer.parseInt(textage.getText().toString());
        weight = Integer.parseInt(textweight.getText().toString());
        goalweight = Integer.parseInt(textgoal.getText().toString());
        workoutperweek = Integer.parseInt(String.valueOf(spinner.getSelectedItem()));
        calorieintake = Integer.parseInt(textcalorieintake.getText().toString());

        if(validpro) {
            mCallbacks.ValidProfile(user, calorieintake, workoutperweek);
        }
        else
        {
            Toast.makeText(myContext, "A value must be entered for every category", Toast.LENGTH_LONG);
        }
    }



    public void selectAllergies(View v)
    {
        final boolean[] checkedItems = new boolean [] {false, false, false, false, false, false, false, false};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.allergy_prompt)
                .setMultiChoiceItems(R.array.allergy_array, checkedItems,
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
                        for(int i = 0; i < 8; i++)
                        {
                            if(checkedItems[i])
                            {
                                myAllergies.add(allAllergies[i]);
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
    }

    public void addSpinnerListener(View v)
    {
        spinner = (Spinner) v.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


}
