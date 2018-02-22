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
public class BestOfFragment extends Fragment {
    DownloadManager downloadManager;
    private FloatingActionButton fabutton;

    public BestOfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        //Creating an arraylist adapter to display the name of the book the author and the image accompanied by the book.
        final ArrayList<book> books = new ArrayList();
        books.add(new book("The Underground Railroad", "by Colson Whitehead", R.drawable.bbook1,"Goodreads: 4/5"));
        books.add(new book("When Breath Becomes Air", "by Paul Kalanithi", R.drawable.bbook2, "Goodreads: 4.3/5"));
        books.add(new book("The Girls", "by Emma Cline", R.drawable.bbook3,"Goodreads: 3.5/5"));
        books.add(new book("Homegoing", "by Yaa Gyasi", R.drawable.bbook4 ,"Goodreads: 4.4/5"));
        books.add(new book("Swing Time", "by Zadie Smith", R.drawable.bbook5,"Goodreads: 3.7/5"));
        books.add(new book("Evicted", " by Matthew Desmond", R.drawable.bbooks6,"Goodreads: 4.5/5"));
        books.add(new book("The Gene: An Intimate History", "by Siddhartha Mukherjee", R.drawable.bbook7,"Goodreads: 4.4/5"));
        books.add(new book("Hillbilly Elegy", "J. D. Vance", R.drawable.bbook8,"Goodreads: 4/5"));
        books.add(new book("Commonwealth", "by Ann Patchett", R.drawable.bbook9,"Goodreads: 3.9/5"));
        books.add(new book("Barkskins", "by Annie Proulx", R.drawable.bbook10,"Goodreads: 3.7/5"));
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
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 1)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 2)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 3)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 4)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 5)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 6)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 7)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 8)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 9)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse("http://files.stupidsid.com/university_papers/engineering/D16/FE/Sem-1/AC1.pdf");
                    DownloadManager.Request request = new DownloadManager.Request(uri);
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    Long reference = downloadManager.enqueue(request);

                }

                if (position == 10)
                {
                    Toast.makeText(getActivity(), "Your Download has Started.", Toast.LENGTH_SHORT).show();
                    downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
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
