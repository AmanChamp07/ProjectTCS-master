package com.example.keshav.projecttcs;

/**
 * Created by keshav on 17-07-2017.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class BeneficiaryRecyclerAdapter extends BaseAdapter{
    Context c;
    ArrayList<DonorDeatils> donors;
    DatabaseReference db;

    BeneficiaryRecyclerAdapter(Context c, ArrayList<DonorDeatils> donors){
        Log.e("Aman","Benificiary Const");
        this.c = c;
//        db = FirebaseDatabase.getInstance().getReference();
//        this.donors = new FirebaseRetrieve(db).getDonorsMuskan();
        for (DonorDeatils d: donors){
            Log.e("Aman:",d.getUsername());
       }
        this.donors = donors;
    }

    @Override
    public int getCount() {
        return donors.size();
    }

    @Override
    public Object getItem(int position) {
        return donors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(c).inflate(R.layout.listviewdatalayout, parent, false);

        for (DonorDeatils d: donors){
            Log.e("Aman init:",d.getUsername());
        }

        TextView donorName = (TextView) convertView.findViewById(R.id.donor_name);
        TextView donorContact = (TextView) convertView.findViewById(R.id.donor_contact);
        TextView donorCity = (TextView) convertView.findViewById(R.id.donor_city);
        TextView donorBloodGroup = (TextView) convertView.findViewById(R.id.donor_blood_group);

        final DonorDeatils donorDeatils = (DonorDeatils) this.getItem(position);

        donorName.setText(donorDeatils.getUsername());
        donorCity.setText("City: "+donorDeatils.getCity());
        donorContact.setText("Contact: "+donorDeatils.getMobile());
        donorBloodGroup.setText("Blood Group: "+donorDeatils.getBloodgroup());
        Log.e("Dono: ",donorDeatils.getUsername());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details = "Name: "+donorDeatils.getUsername()+"\nContact: "+donorDeatils.getMobile()+"\nCity: "+donorDeatils.getCity()+"\nBlood Group: "+donorDeatils.getBloodgroup();

                new AlertDialog.Builder(c).setIcon(null).setTitle("Donor Details").setMessage(details).setPositiveButton("Send Request", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(c, "Request Notification under Process", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return convertView;
    }
}
