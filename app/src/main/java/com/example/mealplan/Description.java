package com.example.mealplan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by tconnel1 on 2/11/2015.
 */
public class Description extends Activity{

    String passedVar=null;
    private TextView passedView=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listitem);
        passedVar=getIntent().getStringExtra("Carbs");
        passedView=(TextView)findViewById(R.id.description01);
        passedView.setText("This item has "+passedVar+ " Carbohydrates.");

    }
}
