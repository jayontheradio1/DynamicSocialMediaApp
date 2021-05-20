package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_PDF_Files extends AppCompatActivity {

    ListView myPDFListView;
    DatabaseReference databaseReference;
    List<PDFUpload> uploadPDFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__p_d_f__files);

        myPDFListView = findViewById(R.id.myListView);
        uploadPDFS = new ArrayList<>();

        viewALLfiles();

        myPDFListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PDFUpload pdfUpload = uploadPDFS.get(position);

                Intent intent = new Intent();
                intent.setData(Uri.parse(pdfUpload.getUrl()));
                startActivity(intent);

            }
        });

    }

    private void viewALLfiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Year1").child("Mathematics");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    PDFUpload pdfUpload = postSnapshot.getValue(PDFUpload.class);
                    uploadPDFS.add(pdfUpload);
                }
                String[] upload = new String[uploadPDFS.size()];

                for(int i=0; i< upload.length;i++){

                    upload[i]=uploadPDFS.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,upload);
                myPDFListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
