package com.example.keshav.projecttcs;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by AmanPC on 23-07-2017.
 */

public class FirebaseRetrieve {
    DatabaseReference db;
    ArrayList<DonorDeatils> donors = new ArrayList<>();

    public FirebaseRetrieve(DatabaseReference db){
        this.db = db;
    }

    private void getDetails(DataSnapshot dataSnapshot){
        donors.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()){
            DonorDeatils donorDeatils = ds.getValue(DonorDeatils.class);
            donors.add(donorDeatils);
        }

    }

    //RETRIEVE
    public ArrayList<DonorDeatils> retrieve(){
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getDetails(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getDetails(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return donors;
    }
}
