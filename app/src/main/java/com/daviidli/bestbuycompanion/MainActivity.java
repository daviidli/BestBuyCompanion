package com.daviidli.bestbuycompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    public static LinkedList<Customer> customerList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
//        DatabaseReference databaseRefChildQueue = database.getReference().child("queue");

        DatabaseReference databaseRefChildCustomers = database.getReference().child("customers");
        DatabaseReference databaseRefListCustomers = databaseRefChildCustomers.child("listCustomers");

        databaseRefListCustomers.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> customers = dataSnapshot.getChildren();
                for (DataSnapshot customer: customers) {
                    Customer newCustomer = customer.getValue(Customer.class);

                    customerList.addLast(newCustomer);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
//        ++queueNumber;
        //databaseRefChildQueue.setValue(queueNumber);

    }

    public void next(View view) {
        Intent k = new Intent(MainActivity.this, List.class);
        startActivity(k);
    }
}
