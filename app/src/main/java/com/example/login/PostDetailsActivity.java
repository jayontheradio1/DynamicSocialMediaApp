package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class PostDetailsActivity extends AppCompatActivity {

    ImageView imgPost,imgUserPost,imgCurrentUser;
    TextView txtPostDesc,txtPostDateName,txtPostTitle;
    EditText editTextComment;
    Button btnAddComment;
    String PostKey;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    RecyclerView RvComment;
    CommentAdapter commentAdapter;
    List<Comment> listComment;
    static String COMMENT_KEY="Comment";
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getSupportActionBar().hide();


        imgPost = findViewById(R.id.post_detail_img);
        txtPostDateName = findViewById(R.id.post_details_date_name);
        txtPostDesc = findViewById(R.id.post_details_description);
        txtPostTitle = findViewById(R.id.post_detail_title);
        editTextComment = findViewById(R.id.post_detail_comment);
        btnAddComment = findViewById(R.id.post_detail_add_comment_btn);
        RvComment = findViewById(R.id.rv_comment);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();



            btnAddComment.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    if (validate2()) {
                        btnAddComment.setVisibility(View.INVISIBLE);
                        DatabaseReference commentRef = firebaseDatabase.getReference(COMMENT_KEY).child(PostKey).push();
                        String comment_content = editTextComment.getText().toString();
                        String uid = firebaseUser.getUid();
                        String uname = firebaseUser.getEmail();
                        Comment comment = new Comment(comment_content, uid, uname);

                        commentRef.setValue(comment).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                showMessage("Comment added successfully");
                                editTextComment.setText("");
                                btnAddComment.setVisibility(View.VISIBLE);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                showMessage("Failed to add comment" + e.getMessage());
                            }
                        });


                    }
                    else{
                        Toast.makeText(PostDetailsActivity.this, "Please Type a Comment!", Toast.LENGTH_SHORT).show();

                    }

                }
            });




        String postImage = getIntent().getExtras().getString("postImage");
        Glide.with(this).load(postImage).into(imgPost);

        String postTitle = getIntent().getExtras().getString("title");
        txtPostTitle.setText(postTitle);

        String postDesc = getIntent().getExtras().getString("description");
        txtPostDesc.setText(postDesc);


        PostKey = getIntent().getExtras().getString("postKey");



        String date = timeStampTOString(getIntent().getExtras().getLong("postDate"));
        txtPostDateName.setText(date);


        iniRvComment();






    }

    private void iniRvComment() {

        RvComment.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference commentRef = firebaseDatabase.getReference(COMMENT_KEY).child(PostKey);
        commentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listComment = new ArrayList<>();
                for(DataSnapshot snap:dataSnapshot.getChildren()){

                    Comment comment = snap.getValue(Comment.class);
                    listComment.add(comment);
                }

                commentAdapter = new CommentAdapter(getApplicationContext(),listComment);
                RvComment.setAdapter(commentAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void showMessage(String s) {

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

    }

    private String timeStampTOString(long time){
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy hh:mm aa",calendar).toString();
        return date;

    }
    private Boolean validate2(){
        Boolean result = false;
        content = editTextComment.getText().toString();


        if(content.isEmpty() ){

            Toast.makeText(this,"Please Type a Comment!",Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }


}
