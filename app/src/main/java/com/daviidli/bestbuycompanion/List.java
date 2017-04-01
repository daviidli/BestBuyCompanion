package com.daviidli.bestbuycompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;

public class List extends AppCompatActivity {

    private ArrayList<String> names = new ArrayList<>();
    private LinkedList<Customer> customers = MainActivity.customerList;
    public static String selectedName = "none";
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (Customer customer : customers) {
            names.add(customer.getName());
        }

        populateList();
        registerClickCallBack();
    }

    private void populateList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_items, names);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                selectedName = textView.getText().toString();

                database = FirebaseDatabase.getInstance();

                DatabaseReference databaseRefChildCustomers = database.getReference().child("customers");
                DatabaseReference databaseRefListCustomers = databaseRefChildCustomers.child("listCustomers");

                databaseRefListCustomers.addValueEventListener(new ValueEventListener() {
                    public int i = 0;

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> customers = dataSnapshot.getChildren();
                        for (DataSnapshot customer: customers) {
                            if (i == 0) {
                                customer.getRef().removeValue();
                                i = 1;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });

                Intent k = new Intent(List.this, CurrentlyHelping.class);
                startActivity(k);
            }
        });
    }
}
