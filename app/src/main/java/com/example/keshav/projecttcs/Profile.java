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

import java.util.ArrayList;
import java.util.jar.Attributes;

import static com.example.keshav.projecttcs.DatabaseHelper.COLUMN_EMAIL;

/**
 * Created by keshav on 25-06-2017.
 */

public class Profile extends MainActivity {

   /* FirebaseDatabase database= FirebaseDatabase.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference db = database.getReference().child("Donors").child(user.getUid()); */
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    FirebaseDatabase fdata = FirebaseDatabase.getInstance();
    DatabaseReference db = fdata.getReference().child("Donors");


    static TextView name,age,height,bloodgroup,city,phone;
    Button btnviewAll;

    Button display;

    static boolean flag;
    static ArrayList<ProfileDetails> user_profile = new ArrayList<>();

    ProfileDetails pd = new ProfileDetails();
    Signup signup = new Signup();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       /* Log.e("Curr user",user.getUid());


       /* db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               /* Log.e("PROFILE: ",dataSnapshot.child("Name").getValue().toString());
                pd.setCity(dataSnapshot.child("City").getValue().toString());
                pd.setName(dataSnapshot.child("Name").getValue().toString());
                pd.setAge(dataSnapshot.child("Age").getValue().toString());
                pd.setBloodGroup(dataSnapshot.child("Blood Group").getValue().toString());
                pd.setContact(dataSnapshot.child("Contact").getValue().toString());
                user_profile.add(pd);*/
        //}

           /* @Override
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
        }); */

        name = (TextView) findViewById(R.id.prname);
        age = (TextView) findViewById(R.id.prage);
        bloodgroup = (TextView) findViewById(R.id.prweight);
        city = (TextView) findViewById(R.id.prdate);
        phone = (TextView) findViewById(R.id.prphone);

        //show_details();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
