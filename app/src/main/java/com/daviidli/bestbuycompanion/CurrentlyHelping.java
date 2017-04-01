package com.daviidli.bestbuycompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CurrentlyHelping extends AppCompatActivity {

    private String selectedName = List.selectedName;
    private String comments = List.comments;
    private Departments department = List.department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_helping);

        TextView currentlyHelping = (TextView) findViewById(R.id.currentlyHelping);
        currentlyHelping.setText("You are currently helping " + selectedName + ". " +
                "\n\nThey are interested in department: " + department + "\n\n" + '"' + comments + '"');
    }

    public void done(View view) {
        Intent k = new Intent(CurrentlyHelping.this, MainActivity.class);
        startActivity(k);
    }
}
