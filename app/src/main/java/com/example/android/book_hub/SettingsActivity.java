package com.example.android.book_hub;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.os.Build.VERSION_CODES.M;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

private TextView textSignOut,textFAQ,textContact,textSignedInUser;
    //firebase auth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        textSignOut=(TextView) findViewById(R.id.sign_out);
        textFAQ=(TextView) findViewById(R.id.faq);
        textContact=(TextView) findViewById(R.id.contact);
        textSignedInUser=(TextView)findViewById(R.id.signed_user);
        if(user!=null) {
            textSignedInUser.setText(user.getEmail());
        }
        textSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == textSignOut){
            //logging out the user
            firebaseAuth.signOut();

            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main2, menu);
        return true;
    }
//back arrow key
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
