package com.better.nutritiontherapy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreatePostActivity extends AppCompatActivity {

    private EditText blog, title;
    private TextView post, one, two, three, four, five, ctv, ptv;
    private LinearLayout category, picture;
    private HorizontalScrollView scrollView;
    private Uri uri;
    private String txt, TITLE, randomNumber = "", url, DATE;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

    private DatabaseReference ref, profileRef;
    private StorageReference storageRef;
    private Dialog dialog;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        gettingLayoutIDs();
        onClickListeners();

        Date date = new Date();
        DATE = sdf.format(date);
    }

    private void chooseImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            uri = data.getData();
            ptv.setText("Image has been selected");
        }
    }

    private void uploadToFirebase(){
        Bitmap bmp = null;
        try {
            bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //here you can choose quality factor in third parameter(ex. i choosen 20)
        bmp.compress(Bitmap.CompressFormat.JPEG, 15, baos);
        byte[] fileInBytes = baos.toByteArray();

        final StorageReference photoref = storageRef.child(uri.getLastPathSegment());

        photoref.putBytes(fileInBytes).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                photoref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        url = uri.toString();

                        String alphabet = "abcdefghijklmnopqrstuvwxyz";
                        Random random = new Random();

                        for (int i=0; i<30; i++){
                            char c = alphabet.charAt(random.nextInt(alphabet.length()));
                            String some = Character.toString(c);
                            randomNumber = some + randomNumber;
                        }
                        final PostModel model = new PostModel(TITLE, txt, ctv.getText().toString(), url, randomNumber, FirebaseAuth.getInstance().getUid(), "0", "0", DATE, System.currentTimeMillis());
                        ref.child(ctv.getText().toString()).child(randomNumber).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    profileRef.child(FirebaseAuth.getInstance().getUid()).child(randomNumber).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(CreatePostActivity.this, "Post Successful", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(CreatePostActivity.this, HomeActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else Toast.makeText(CreatePostActivity.this, "Post Failed", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    });
                                }
                                else Toast.makeText(CreatePostActivity.this, "Post Failed", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreatePostActivity.this, "Post Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate(){
        boolean valid = true;

        if (TITLE.isEmpty()){
            Toast.makeText(CreatePostActivity.this, "Define your blog title", Toast.LENGTH_SHORT).show();
            title.requestFocus();
            valid = false;
        }

        else if (txt.isEmpty()){
            Toast.makeText(CreatePostActivity.this, "Write your blog first", Toast.LENGTH_SHORT).show();
            blog.requestFocus();
            valid = false;
        }

        else if (ctv.getText().toString().equals("Select a category")){
            Toast.makeText(CreatePostActivity.this, "Select your blog category", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        else if (uri == null){
            Toast.makeText(CreatePostActivity.this, "Choose your blog picture", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }

    private void onClickListeners(){
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt = blog.getText().toString();
                TITLE = title.getText().toString();

                if (validate()){
                    showProgress();
                    uploadToFirebase();
                }
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.VISIBLE);
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                ctv.setText(one.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                ctv.setText(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                ctv.setText(three.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                ctv.setText(four.getText().toString());
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.setVisibility(View.GONE);
                ctv.setText(five.getText().toString());
            }
        });
    }

    private void showProgress(){
        dialog.setContentView(R.layout.progress_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void gettingLayoutIDs(){
        title = findViewById(R.id.blog_title);
        blog = findViewById(R.id.write_post);
        post = findViewById(R.id.post_btn);
        category = findViewById(R.id.choose_category);
        picture = findViewById(R.id.choose_picture);
        scrollView = findViewById(R.id.post_category);
        one = findViewById(R.id.cone);
        two = findViewById(R.id.ctwo);
        three = findViewById(R.id.cthree);
        four = findViewById(R.id.cfour);
        five = findViewById(R.id.cfive);
        ctv = findViewById(R.id.ctv);
        ptv = findViewById(R.id.ptv);

        dialog = new Dialog(this);

        ref = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Posts");
        profileRef = FirebaseDatabase.getInstance().getReference().child("Blog App").child("Users Post");
        storageRef = FirebaseStorage.getInstance().getReference().child("Blog Pictures");
    }
}

