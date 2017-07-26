package com.example.keshav.projecttcs;

/**
 * Created by keshav on 17-07-2017.
 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BeneficiaryListActivity extends AppCompatActivity {


    //private AppCompatActivity activity = BeneficiaryListActivity.this;
    /*Context context = BeneficiaryListActivity.this;
    private RecyclerView recyclerViewBeneficiary;
    private ArrayList<DonorDeatils> listBeneficiary;
    private List<DonorDeatils> newDList;
    private ArrayList<AcceptRequest> requestList;
    private BeneficiaryRecyclerAdapter beneficiaryRecyclerAdapter;
    List<String> endUserID = new ArrayList<String>();

    DatabaseReference dref = FirebaseDatabase.getInstance().getReference().child("Donors");
    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    String Uid = firebaseUser.getUid(); */

    DatabaseReference db;
    FirebaseRetrieve fr;
    BeneficiaryRecyclerAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary_list);

       /* recyclerViewBeneficiary = (RecyclerView) findViewById(R.id.recyclerViewBeneficiary);
        listBeneficiary = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewBeneficiary.setLayoutManager(mLayoutManager);
        recyclerViewBeneficiary.setItemAnimator(new DefaultItemAnimator());
        recyclerViewBeneficiary.setHasFixedSize(true);
        recyclerViewBeneficiary.setAdapter(beneficiaryRecyclerAdapter);;
        beneficiaryRecyclerAdapter.notifyDataSetChanged();  */

        listView = (ListView) findViewById(R.id.userList);

        db = FirebaseDatabase.getInstance().getReference();
        fr = new FirebaseRetrieve(db);
        fr.retrieve();
        do {
            adapter = new BeneficiaryRecyclerAdapter(this, fr.getDonorsMuskan());
        } while (fr.getDonorsMuskan() == null);
        listView.setAdapter(adapter);

        Button b = (Button) findViewById(R.id.refresh);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BeneficiaryListActivity.this);
                alertDialogBuilder.setTitle("Blood Donation Request");
                alertDialogBuilder.setMessage("Do you want to send request to this donor?").setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sendrequest sendRequest = new Sendrequest();
                                sendRequest.sendNotification();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        });
    }
}
