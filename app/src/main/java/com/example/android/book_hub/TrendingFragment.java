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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.book_hub.R.drawable.b;
import static com.example.android.book_hub.R.id.fab;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment {
    DownloadManager downloadManager;
    private FloatingActionButton fabutton;

    public TrendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        //Creating an arraylist adapter to display the name of the book the author and the image accompanied by the book.
        final ArrayList<book> books = new ArrayList();
        books.add(new book("Lincoln in the Bardo", "by George Saunders", R.drawable.book1, "Goodreads: 4.2/5"));
        books.add(new book("Difficult Women", "by Roxane Gay", R.drawable.book2, "Goodreads: 4/5"));
        books.add(new book("Norse Mythology", "by Neil Gaiman", R.drawable.book3, "Goodreads: 4.2/5"));
        books.add(new book("A Separation", "by Katie Kitamura", R.drawable.book4, "Goodreads: 3/5"));
        books.add(new book("All Grown Up", "by Jami Attenberg", R.drawable.book5, "Goodreads: 3.6/5"));
        books.add(new book("The Idiot", "by Elif Batuman", R.drawable.book6, "Goodreads: 3.5/5"));
        books.add(new book("The Refugees", "by Viet Thanh Nguyen", R.drawable.book7, "Goodreads: 4/5"));
        books.add(new book("The Twelve Lives of Samuel Hawley", "by Hannah Tinti", R.drawable.book8, "Goodreads: 4.2/5"));
        books.add(new book("The Rules Do Not Apply: A Memoir", "by Ariel Levy", R.drawable.book9, "Goodreads: 3.9/5"));
        books.add(new book("4 3 2 1 * Signed *", "by Paul Auster", R.drawable.book10, "Goodreads: 3.9/5"));
        bookAdapter adapter = new bookAdapter(getActivity(), books);
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
                            Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
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

