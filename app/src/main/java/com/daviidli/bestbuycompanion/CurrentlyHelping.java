package com.daviidli.bestbuycompanion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CurrentlyHelping extends AppCompatActivity {

    private String selectedName = List.selectedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_helping);

        TextView currentlyHelping = (TextView) findViewById(R.id.currentlyHelping);
        currentlyHelping.setText("You are currently helping " + selectedName + ". " +
                "They are interested in: ...");
    }
}
