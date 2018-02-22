package com.example.android.book_hub;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.ref.Reference;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileImage;
    private TextView email,username,gender,bio;
    private FirebaseAuth firebaseAuth;
    ListView lv;
    DownloadManager downloadManager;
    String[] booknames={"The Shining", "Swing Time","The Refugees", "A Study in Scarlet", "'Salem's Lot"};
    String[] authors={"by Stephen King", "by Zadie Smith","by Viet Thanh Nguyen","by Arthur Conan Doyle","by Stephen King"};
    String[] rating={"Goodreads: 4.2/5","Goodreads: 3.7/5","Goodreads: 4/5","Goodreads: 4.1/5","Goodreads: 4/5"};
    int image[]={R.drawable.reb1, R.drawable.bbook5,R.drawable.book7, R.drawable.rb7, R.drawable.rb3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
        }
        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        setContentView(R.layout.activity_profile);
        email = (TextView) findViewById(R.id.text_email);
        if(user!=null)
        {
            email.setText(user.getEmail());
        }

        lv=(ListView)findViewById(R.id.list);
        ProfileAdapter adapter=new ProfileAdapter(this,booknames,authors,rating,image);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                {
                    Toast.makeText(ProfileActivity.this, "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/bookish-app.appspot.com/o/32285?alt=media&token=94827e7e-f8a4-49f9-b21e-e5a276707c0b");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 1)
                {
                    Toast.makeText(ProfileActivity.this, "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 2)
                {
                    Toast.makeText(ProfileActivity.this, "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 3)
                {
                    Toast.makeText(ProfileActivity.this, "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 4)
                {
                    Toast.makeText(ProfileActivity.this, "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                return true;
            case R.id.action_settings:
                Intent intent2 = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent2);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
