package com.example.android.book_hub;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.book_hub.R.id.fab;

/**
 * A simple {@link Fragment} subclass.
 */
public class recommFragment extends Fragment {
    DownloadManager downloadManager;
    private FloatingActionButton fabutton;

    public recommFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        //Creating an arraylist adapter to display the name of the book the author and the image accompanied by the book.
        final ArrayList<book> books = new ArrayList();
        books.add(new book("The Shining", "by Stephen King", R.drawable.reb1,"Goodreads: 4.2/5"));
        books.add(new book("Harry Potter and the Order of the Phoenix", "by J. K. Rowling", R.drawable.rb4, "Goodreads: 4.5/5"));
        books.add(new book("Nineteen Eighty-Four", "by George Orwell", R.drawable.rb5,"Goodreads: 4.1/5"));
        books.add(new book("The Devotion of Suspect X", "by Keigo Higashino", R.drawable.rb6 ,"Goodreads: 4/5"));
        books.add(new book("A Study in Scarlet", "by Arthur Conan Doyle", R.drawable.rb7,"Goodreads: 4.1/5"));
        books.add(new book("Misery", "by Stephen King", R.drawable.rb2,"Goodreads: 4.1/5"));
        books.add(new book("Oliver Twist", "by Charles Dickens", R.drawable.rb8,"Goodreads: 4.4/5"));
        books.add(new book("Red Dragon", "by Thomas Harris", R.drawable.rb9,"Goodreads: 4/5"));
        books.add(new book("Commonwealth", "by Ann Patchett", R.drawable.bbook9,"Goodreads: 3.9/5"));
        books.add(new book("'Salem's Lot", "by Stephen King", R.drawable.rb3,"Goodreads: 4/5"));
        bookAdapter adapter = new bookAdapter(getActivity(), books );

        fabutton=(FloatingActionButton) rootView.findViewById(fab);
        fabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat=new Intent(getContext(),activity_main_chat.class);
                startActivity(chat);
            }
        });

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/bookish-app.appspot.com/o/32285?alt=media&token=94827e7e-f8a4-49f9-b21e-e5a276707c0b");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 1)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 2)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 3)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 4)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 5)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 6)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 7)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 8)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 9)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 10)
                {
                    Toast.makeText(getContext(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }


                return false;
            }
        });
        return rootView;
    }

}