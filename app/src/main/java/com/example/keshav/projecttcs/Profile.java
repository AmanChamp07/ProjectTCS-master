package com.example.keshav.projecttcs;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

import static com.example.keshav.projecttcs.DatabaseHelper.COLUMN_EMAIL;

/**
 * Created by keshav on 25-06-2017.
 */

public class Profile extends MainActivity {

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference db = database.getReference().child("Donors").child(user.getUid());


    static TextView name,age,height,weight,ldate,phone;
    Button btnviewAll;

    Button display;

    static boolean flag;

    DatabaseHelper helper = new DatabaseHelper(this);

    Profile profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("USer: ",dataSnapshot.child("Name").getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

        name = (TextView)findViewById(R.id.prname);
        age=(TextView)findViewById(R.id.prage);
        weight=(TextView)findViewById(R.id.prweight);
        ldate=(TextView)findViewById(R.id.prdate);
        phone=(TextView)findViewById(R.id.prphone);

        btnviewAll = (Button)findViewById(R.id.btn_change);
        Log.i("Profile: ",db.child("Name").toString());


    }


}
