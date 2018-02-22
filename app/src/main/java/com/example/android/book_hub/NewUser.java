package com.example.android.book_hub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.N;
import static com.example.android.book_hub.R.id.gender;
import static com.example.android.book_hub.R.id.login;


public class NewUser extends AppCompatActivity implements View.OnClickListener {

    //Image
    //a constant to track the file chooser intent
    private static final int PICK_IMAGE_REQUEST = 234;
    StorageReference storageReference;
    //Database
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    //defining view objects
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonSignup;
    private ProgressDialog progressDialog;
    private RadioGroup gendergroup;
    private RadioButton selectedGender;
    private EditText editTextUserBio;
    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;
    //ImageView
    private ImageView imageView;
    //a Uri object to store file path
    private Uri filePath;
    String photourl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        Button login = (Button) findViewById(R.id.signin);
        // Set a click listener on that View
        login.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            public void onClick(View view) {
                Intent loginIntent = new Intent(NewUser.this, MainActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        imageView = (ImageView) findViewById(R.id.profilepic);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //initializing views
        editTextUsername = (EditText) findViewById(R.id.username);
        editTextEmail = (EditText) findViewById(R.id.nuemail);
        editTextPassword = (EditText) findViewById(R.id.nupass);
        editTextConfirmPassword = (EditText) findViewById(R.id.confirmpass);
        buttonSignup = (Button) findViewById(R.id.nuregister);
        progressDialog = new ProgressDialog(this);
        gendergroup = (RadioGroup) findViewById(gender);
        editTextUserBio = (EditText) findViewById(R.id.bio);
        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        imageView.setOnClickListener(this);
        storageReference = FirebaseStorage.getInstance().getReference();

        //Database
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://bookish-app.firebaseio.com/");

    }

    //IMAGE

    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //this method will upload the file
    private void uploadFile() {
        //if there is a file to upload
        if (filePath != null) {
            //displaying a progress dialog while upload is going on
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();
            photourl=filePath.getLastPathSegment().toString();
            StorageReference riversRef = storageReference.child(photourl);
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //if the upload is successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying a success toast
                            Toast.makeText(getApplicationContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            //if the upload is not successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying error message
                            Toast.makeText(getApplicationContext(), "Cant upload", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //calculating progress percentage
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                            //displaying percentage in progress dialog
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    });
        }

    }


    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        uploadFile();
    }

    @Override
    public void onClick(View view) {
        //if the clicked button is choose
        if (view == imageView) {
            showFileChooser();
        }
        //if the clicked button is upload
        else if (view == buttonSignup) {
            registerUser();
        }
    }

    private void registerUser() {

        //getting email and password from edit texts
        final String username = editTextUsername.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        final String bio = editTextUserBio.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please Enter your Username", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please Enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter password", Toast.LENGTH_LONG).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password too short, Enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "Please Re-Enter password", Toast.LENGTH_LONG).show();
            return;
        }

        if (!(password.equals(confirmPassword))) {
            Toast.makeText(this, "Password does not match.Please Re-Enter password", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(bio)) {
            Toast.makeText(this, "Please Enter your Bio", Toast.LENGTH_LONG).show();
            return;
        }

        if (bio.length() > 15) {
            Toast.makeText(this, "Please Enter a short Bio", Toast.LENGTH_SHORT).show();
            return;
        }

        // get selected radio button from radioGroup
        int selectedId = gendergroup.getCheckedRadioButtonId();
        selectedGender = (RadioButton) findViewById(selectedId);
        final String gender = selectedGender.getText().toString();

        if (selectedId == -1) {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
            return;
        }


        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        String databaseId;
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            DatabaseReference mchild = databaseReference.push();
                            databaseId=mchild.getKey();
                            UserInfo info =new UserInfo(databaseId,email,username,bio,gender,photourl);
//                            mchild.child("Email").setValue(email);
//                            mchild.child("Username").setValue(username);
//                            mchild.child("BIO").setValue(bio);
//                            mchild.child("Gender").setValue(gender);
//                            mchild.child("UserAuth Id").setValue(user.getUid());
//                            mchild.child("Photo url").setValue(photourl);
//                            mchild.child("Database Id").setValue(databaseId);
                            //display some message here


                            Toast.makeText(NewUser.this, "Successfully registered", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            //display some message here
                            Toast.makeText(NewUser.this, "Registrartion Error.User is already Registered", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

        //Database

    }

//    @Override
//    public void onClick(View view) {
//        //calling register method on click
//        registerUser();
//    }
}